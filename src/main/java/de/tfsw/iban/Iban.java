/*
 *  Copyright 2017 Thorsten Frank
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package de.tfsw.iban;

import java.math.BigInteger;
import java.util.regex.Pattern;

/**
 * An international bank account number as defined by ISO 13616-1:2007.
 * 
 * <p>
 * Objects of this class are immutable and thread-safe.
 * </p>
 * 
 * @author Thorsten Frank
 */
public class Iban {

	private static final String DEFAULT_CHECKSUM = "00";

	private static final String WHITESPACE_REGEX = "\\s";

	private static final String EMPTY_STRING = "";

	private static final String BLANK_STRING = " ";

	private static final Pattern IBAN_PATTERN = Pattern.compile("[A-Z]{2}\\d{2}\\w{1,30}");

	private static final int CCODE_START_INDEX = 0;

	private static final int CHECKSUM_START_INDEX = 2;

	private static final int BBAN_START_INDEX = 4;

	private static final BigInteger NINETY_SEVEN = new BigInteger("97");

	private static final BigInteger NINETY_EIGHT = new BigInteger("98");

	private String ibanString;

	private CountryCode countryCode;

	private String checksum;

	private String bban;

	/**
	 * Creates an IBAN object from the supplied string. The supplied string may
	 * include blank strings, but otherwise it must be a valid and complete IBAN
	 * representation.
	 * 
	 * @param ibanString
	 *            IBAN in string representation, may include blanks
	 * 
	 * @throws InvalidChecksumException
	 *             if the supplied IBAN string's check digits are wrong
	 * @throws IllegalArgumentException
	 *             if the supplied string is <code>null</code> or empty
	 * @throws IbanFormatException
	 *             if the supplied IBAN's basic format is invalid
	 * @throws UnknownCountryCodeException
	 *             if the first to characters of the supplied string do not
	 *             correspond to one of the codes defines in {@link CountryCode}
	 * @throws BbanValidationException
	 *             if the BBAN part of the supplied string is invalid according
	 *             to the country's IBAN specification
	 *             
	 * @see #validateIban(String)
	 */
	public Iban(String iban) {
		super();
		
		this.ibanString = validateIban(iban); // MOD97-10 check

		this.countryCode = parseCountryCode(ibanString);
		this.bban = ibanString.substring(BBAN_START_INDEX);

		validateBban(); // strict, country-specific BBAN validation
		
		this.checksum = this.ibanString.substring(CHECKSUM_START_INDEX, BBAN_START_INDEX);
	}

	/**
	 * Creates a new IBAN form the supplied country code and BBAN (basic bank
	 * account number). The BBAN is validated according to the country-specific
	 * rules and the check digits are calculated an will be available by calling
	 * {@link #getChecksum()}.
	 * 
	 * @param countryCode
	 *            the ISO 3361-1 CountryCode
	 * 
	 * @param bban
	 *            the country-specific account number
	 * 
	 * @throws IllegalArgumentException
	 *             if the supplied {@link CountryCode} is <code>null</code>
	 * @throws BbanValidationException
	 *             if the supplied BBAN is invalid according to the country
	 *             code's format
	 */
	public Iban(CountryCode countryCode, String bban) {
		super();
		if (countryCode == null) {
			throw new IllegalArgumentException("Country code must be a valid ISO 3361-1 two-letter ID");
		}

		this.countryCode = countryCode;
		this.bban = removeWhitespace(bban);
		validateBban();
		this.checksum = calculateChecksum();
		this.ibanString = this.countryCode.toString() + this.checksum + this.bban;
	}

	/**
	 * Validates the supplied IBAN string representation by checking the basic
	 * structure as defined by <code>ISO 13616</code> and the check digits
	 * according to <code>ISO/IEC 7064 MOD97-10</code>.
	 * 
	 * <p>
	 * This method implements a <i>relaxed</i> validation in that it checks neither the country code nor the
	 * country-specific BBAN length or format.
	 * </p>
	 * 
	 * @param iban
	 *            the IBAN to validate, may contain blanks
	 * 
	 * @return the machine-readable IBAN, i.e. the input value without any whitespace
	 * 
	 * @throws IbanFormatException
	 *             if the supplied IBAN does not conform to the format defined
	 *             in <code>ISO 13616</code>
	 * @throws InvalidChecksumException
	 *             if the MOD97-10 checksum calculation fails
	 */
	public static String validateIban(final String iban) {
		final String ibanFlat = removeWhitespace(iban);
		if (ibanFlat == null || false == IBAN_PATTERN.matcher(ibanFlat).matches()) {
			throw new IbanFormatException("Not a valid IBAN format: " + iban);
		}

		final StringBuilder sb = new StringBuilder(ibanFlat.substring(BBAN_START_INDEX));
		sb.append(ibanFlat.subSequence(CCODE_START_INDEX, BBAN_START_INDEX));
		replaceLettersWithDigitRepresentation(sb);

		BigInteger remainder = new BigInteger(sb.toString()).mod(NINETY_SEVEN);
		if (!BigInteger.ONE.equals(remainder)) {
			throw new InvalidChecksumException(iban);
		}
		
		return ibanFlat;
	}
	
	/**
	 * 
	 * @return ISO 3166-1 alpha-2 country code identifier
	 */
	public CountryCode getCountryCode() {
		return countryCode;
	}

	/**
	 * 
	 * @return the two check digits of this IBAN
	 */
	public String getChecksum() {
		return checksum;
	}

	/**
	 * Returns everything after the country code and check digit.
	 * 
	 * @return basic country-specific bank account number
	 */
	public String getBban() {
		return bban;
	}

	/**
	 * @return an unformatted string representation of this IBAN
	 */
	@Override
	public String toString() {
		return this.ibanString;
	}

	/**
	 * 
	 * @return a formatted string representation of this IBAN with a blank every
	 *         four characters
	 */
	public String toFormattedString() {
		final StringBuilder sb = new StringBuilder(countryCode.toString()).append(checksum);

		for (int i = 0; i < bban.length(); i += 4) {
			sb.append(BLANK_STRING);

			if (bban.length() - i < 4) {
				sb.append(bban.substring(i));
			} else {
				sb.append(bban.substring(i, i + 4));
			}
		}

		return sb.toString();
	}

	/**
	 * Compares the string representations of the two IBAN instances. More
	 * exactly returns <code>true</code> if this IBAN's {@link #toString()}
	 * equals the supplied one's.
	 * 
	 * @return <code>true</code> if this IBAN is identical to the supplied one
	 * 
	 * @see #toString()
	 */
	@Override
	public boolean equals(Object other) {
		boolean isEqual = false;
		if (other != null && other instanceof Iban) {
			isEqual = this.ibanString.equals(((Iban) other).ibanString);
		}

		return isEqual;
	}

	/**
	 * @return the hash code of this IBAN's string representation
	 * 
	 * @see #toString()
	 */
	@Override
	public int hashCode() {
		return ibanString.hashCode();
	}

	/**
	 * 
	 */
	private void validateBban() {
		if (bban == null) {
			throw new BbanValidationException("BBAN must not be nulL!");
		} else if (bban.length() != countryCode.getBbanLength()) {
			throw new BbanValidationException(String.format("BBAN for country %s must have %d characters, but was %d",
					countryCode, countryCode.getBbanLength(), bban.length()));
		} else if (!bban.matches(countryCode.getBbanPattern())) {
			throw new BbanValidationException(String.format(
					"BBAN [%s] does not match the required pattern for country code %s", bban, countryCode.name()));
		}
	}

	/**
	 * Calculates the Modulo 97 - based check digits based on the country code
	 * and BBAN of this IBAN.
	 * 
	 * @return the calculated checksum
	 */
	private String calculateChecksum() {
		StringBuilder sb = new StringBuilder(bban);
		sb.append(countryCode.toString());
		sb.append(DEFAULT_CHECKSUM);

		replaceLettersWithDigitRepresentation(sb);

		String calculated = NINETY_EIGHT.subtract(new BigInteger(sb.toString()).mod(NINETY_SEVEN)).toString();

		if (calculated.length() < 2) {
			calculated = "0" + calculated;
		}

		return calculated;
	}

	/**
	 * 
	 * @param stringBuilder
	 */
	private static final void replaceLettersWithDigitRepresentation(final StringBuilder stringBuilder) {
		for (int i = 0; i < stringBuilder.length(); i++) {
			final char c = stringBuilder.charAt(i);
			if (Character.isLetter(c)) {
				stringBuilder.replace(i, i + 1, Integer.toString(Character.getNumericValue(c)));
			} else if (!Character.isDigit(c)) {
				throw new BbanValidationException(
						"Illegal character in BBAN. May only contain digits and letters: " + c);
			}
		}
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	private static final String removeWhitespace(final String input) {
		return input == null ? null : input.replaceAll(WHITESPACE_REGEX, EMPTY_STRING);
	}

	/**
	 * Attempts to parse the first two characters of the supplied IBAN and
	 * retrieve the corresponding {@link CountryCode} for that value.
	 * 
	 * @param iban
	 *            a String representing a complete IBAN
	 * 
	 * @return the {@link CountryCode} defined by the IBAN's first two character
	 * 
	 * @throws UnknownCountryCodeException
	 *             if the first two characters do not match any known
	 *             {@link CountryCode}
	 * 
	 * @see CountryCode#fromString(String)
	 */
	private CountryCode parseCountryCode(final String iban) {
		return CountryCode.fromString(iban.substring(CCODE_START_INDEX, CHECKSUM_START_INDEX));
	}
}
