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

/**
 * ISO 3166-1 country codes and IBAN-specific format information.
 * 
 * <p>
 * Based on release 75 of the IBAN Registry, see https://www.swift.com/standards/data-standards/iban
 * </p>
 * 
 * @author Thorsten Frank
 */
public enum CountryCode {

	/** Andorra */
    AD(20, "\\d{4}", "\\d{4}", "\\w{12}"),
    
    /** United Arab Emirates */
    AE(19, "\\d{3}", "\\d{16}"),
    
    /** Albania */
    AL(24, "\\d{8}", "\\w{16}"), // the spec is unclear about the bank and branch IDs - states 8 as total 
    // length, but the spec only notes 7 digits total for these two (Bank: 1-3, Branch: 4-7). We assume the last digit
    // is some sort of check digit, but it's not properly specified - so until that's clear, we can't support separate
    // IDs
    
    /** Austria */
    AT(16, "\\d{5}", "\\d{11}"),
    
    /** Azerbaijan */
    AZ(24, "[A-Z]{4}", "\\w{20}"),
    
    /** Bosnia and Herzegovina */
    BA(16, "\\d{3}", "\\d{3}", "\\d{8}\\d{2}"),
    
    /** Belgium */
    BE(12, "\\d{3}", "\\d{7}\\d{2}"),
    
    /** Bulgaria */
    BG(18, "[A-Z]{4}", "\\d{4}", "\\d{2}\\w{8}"),
    
    /** Bahrain */
    BH(18, "[A-Z]{4}", "\\w{14}"),
    
    /** Brazil */
    BR(25, "\\d{8}", "\\d{5}", "\\d{10}[A-Z]\\w"),
    
    /** Belarus */
    BY(24, "\\w{4}", "\\d{4}\\w{16}"),
    
    /** Switzerland */
    CH(17, "\\d{5}", "\\w{12}"),
    
    /** Costa Rica */
    CR(18, "\\d{4}", "\\d{14}"),
    
    /** Cyprus */
    CY(24, "\\d{3}", "\\d{5}", "\\w{16}"),
    
    /** Czech Republic */
    CZ(20, "\\d{4}", "\\d{6}\\d{10}"),
    
    /** Germany */
    DE(18, "\\d{8}", "\\d{10}"),
    
    /** Denmark */
    DK(14, "\\d{4}", "\\d{9}\\d{1}"),
    
    /** Dominican Republic */
    DO(24, "\\w{4}", "\\d{20}"),
    
    /** Estonia */
    EE(16, "\\d{2}", "\\d{2}\\d{11}\\d"),
    
    /** Spain */
    ES(20, "\\d{4}", "\\d{4}", "\\d\\d\\d{10}"),
    
    /** Finland */
    FI(14, "\\d{3}", "\\d{11}"),
    
    /** Faroe Islands */
    FO(14, "\\d{4}", "\\d{9}\\d"),
    
    /** France */
    FR(23, "\\d{5}", "\\d{5}\\w{11}\\d{2}"),
    
    /** United Kingdom */
    GB(18, "[A-Z]{4}", "\\d{6}", "\\d{8}"),
    
    /** Georgia */
    GE(18, "[A-Z]{2}", "\\d{16}"),
    
    /** Gibraltar */
    GI(19, "[A-Z]{4}", "\\w{15}"),
    
    /** Greenland */
    GL(14, "\\d{4}", "\\d{9}\\d"),
    
    /** Greece */
    GR(23, "\\d{3}", "\\d{4}", "\\w{16}"),
    
    /** Guatemala */
    GT(24, "\\w{4}", "\\w{20}"),
    
    /** Croatia */
    HR(17, "\\d{7}", "\\d{10}"),
    
    /** Hungary */
    HU(24, "\\d{3}", "\\d{4}", "\\d\\d{15}\\d"),
    
    /** Ireland */
    IE(18, "[A-Z]{4}", "\\d{6}", "\\d{8}"),
    
    /** Israel */
    IL(19, "\\d{3}", "\\d{3}", "\\d{13}"),
    
    /** Iraq */
    IQ(19, "[A-Z]{4}", "\\d{3}", "\\d{12}"),
    
    /** Iceland */
    IS(22, "\\d{2}", "\\d{2}", "\\d{2}\\d{6}\\d{10}"),
    
    /** Italy */
    IT(23, "[A-Z]", "\\d{5}", "\\d{5}", "\\w{12}"),
    
    /** Jordan */
    JO(26, "[A-Z]{4}", "\\d{4}\\w{18}"),
    
    /** Kuwait */
    KW(26, "[A-Z]{4}", "\\w{22}"),
    
    /** Kazakhstan */
    KZ(16, "\\d{3}", "\\w{13}"),
    
    /** Lebanon */
    LB(24, "\\d{4}", "\\w{20}"),
    
    /** Saint Lucia */
    LC(28, "[A-Z]{4}", "\\w{24}"),
    
    /** Liechtenstein */
    LI(17, "\\d{5}", "\\w{12}"),
    
    /** Lithuania */
    LT(16, "\\d{5}", "\\d{11}"),
    
    /** Luxembourg */
    LU(16, "\\d{3}", "\\w{13}"),
    
    /** Latvia */
    LV(17, "[A-Z]{4}", "\\w{13}"),

    /** Monaco */
    MC(23, "\\d{5}", "\\d{5}", "\\w{11}\\d{2}"),

    /** Moldova */
    MD(20, "\\w{2}", "\\w{18}"),

    /** Montenegro */
    ME(18, "\\d{3}", "\\d{13}\\d{2}"),
    
    /** Macedonia */
    MK(15, "\\d{3}", "\\w{10}\\d{2}"),
    
    /** Mauritania */
    MR(23, "\\d{5}", "\\d{5}", "\\d{11}\\d{2}"),
    
    /** Malta */
    MT(27, "[A-Z]{4}", "\\d{5}", "\\w{18}"),
    
    /** Mauritius */
    MU(26, "[A-Z]{4}\\d{2}", "\\d{2}", "\\d{12}\\d{3}\\w{3}"),
    
    /** The Netherlands */
    NL(14, "[A-Z]{4}", "\\d{10}"),
    
    /** Norway */
    NO(11, "\\d{4}", "\\d{6}\\d"),
    
    /** Pakistan */
    PK(20, "[A-Z]{4}", "\\w{16}"),
    
    /** Poland */
    PL(24, "\\d{8}", "\\d{16}"),
    
    /** Palestine */
    PS(25, "[A-Z]{4}", "\\w{21}"),

    /** Portugal */
    PT(21, "\\d{4}", "\\d{4}\\d{11}\\d{2}"),
    
    /** Qatar */
    QA(25, "[A-Z]{4}", "\\w{21}"),

    /** Romania */
    RO(20, "[A-Z]{4}", "\\w{16}"),

    /** Serbia */
    RS(18, "\\d{3}", "\\d{13}\\d{2}"),

    /** Saudi Arabia */
    SA(20, "\\d{2}", "\\w{18}"),

    /** Seychelles */
    SC(27, "[A-Z]{4}\\d{2}", "\\d{2}", "\\d{16}[A-Z]{3}"),

    /** Sweden */
    SE(20, "\\d{3}", "\\d{16}\\d"),
    
    /** Slovenia */
    SI(15, "\\d{5}", "\\d{8}\\d{2}"),
    
    /** Slovakia */
    SK(20, "\\d{4}", "\\d{6}\\d{10}"),

    /** San Marino */
    SM(23, "[A-Z]", "\\d{5}", "\\d{5}", "\\w{12}"),

    /** Sao Tome and Principe */
    ST(21, "\\d{4}", "\\d{4}", "\\d{11}\\d{2}"),

    /** El Salvador */
    SV(24, "[A-Z]{4}", "\\d{20}"),

    /** East Timor */
    TL(19, "\\d{3}", "\\d{14}\\d{2}"),

    /** Tunisia */
    TN(20, "\\d{2}", "\\d{3}", "\\d{13}\\d{2}"),
    
    /** Turkey */
    TR(22, "\\d{5}", "\\d\\w{16}"),

    /** Ukraine */
    UA(25, "\\d{6}", "\\w{19}"),
    
    /** Virgin Islands */
    VG(20, "[A-Z]{4}", "\\d{16}"),
    
    /** Kosovo */
    XK(16, "\\d{2}", "\\d{2}", "\\d{10}\\d{2}");
    
	/** Common IBAN check digits pattern. */
	private static final String CHECK_DIGITS_PATTERN = "\\d{2}";
	
	/** Country-specific BBAN length. */
    private int bbanLength;

    /** Regular Expression of the BBAN pattern for this country code. */
    private String bbanPattern;

    /** Regular Expression of the IBAN pattern for this country code. */
    private String ibanPattern;
    
    /** Optional BBAN prefix pattern (e.g. checksum in Italy). */
    private String bbanPrefixPattern;
    
    /** Bank identifier pattern. */
    private String bankIdentifierPattern;
    
    /** Optional branch identifier pattern. */
    private String branchIdentifierPattern;
    
    /** Account number pattern for this country code. */
    private String accountNumberPattern;
    
    /**
	 * @param bbanLength
	 * @param bankIdentifierPattern
	 * @param accountNumberPattern
	 */
	private CountryCode(int bbanLength, String bankIdentifierPattern, String accountNumberPattern) {
		this(bbanLength, bankIdentifierPattern, null, accountNumberPattern);
	}
	
	/**
	 * @param bbanLength
	 * @param bankIdentifierPattern
	 * @param branchIdentifierPattern
	 * @param accountNumberPattern
	 */
	private CountryCode(int bbanLength, String bankIdentifierPattern, String branchIdentifierPattern,
			String accountNumberPattern) {
		this(bbanLength, null, bankIdentifierPattern, branchIdentifierPattern, accountNumberPattern);
	}

	/**
	 * @param bbanLength
	 * @param bbanPrefixPattern
	 * @param bankIdentifierPattern
	 * @param branchIdentifierPattern
	 * @param accountNumberPattern
	 */
	private CountryCode(int bbanLength, String bbanPrefixPattern, String bankIdentifierPattern, String branchIdentifierPattern,
			String accountNumberPattern) {
		this.bbanLength = bbanLength;
		this.bbanPrefixPattern = bbanPrefixPattern;
		this.bankIdentifierPattern = bankIdentifierPattern;
		this.branchIdentifierPattern = branchIdentifierPattern;
		this.accountNumberPattern = accountNumberPattern;
		
		final StringBuilder sb = new StringBuilder();
		if (bbanPrefixPattern != null) {
			sb.append(bbanPrefixPattern);
		}
		
		sb.append(bankIdentifierPattern);
		
		if (branchIdentifierPattern != null) {
			sb.append(branchIdentifierPattern);
		}
		
		sb.append(accountNumberPattern);
		
		this.bbanPattern = sb.toString();
		this.ibanPattern = name() + CHECK_DIGITS_PATTERN + bbanPattern;
	}
	
	/**
     * 
     * @return the length of a BBAN of this country
     */
    public int getBbanLength() {
        return bbanLength;
    }
    
    /**
     * 
     * @return a regular expression describing this country code's BBAN format
     */
    public String getBbanPattern() {
		return bbanPattern;
	}

    /**
     * 
     * @return a regular expression describing this country code's IBAN format
     */
    public String getIbanPattern() {
    	return ibanPattern;
    }
    
    /**
	 * @return the bbanPrefixPattern
	 */
	public String getBbanPrefixPattern() {
		return bbanPrefixPattern;
	}

	/**
	 * 
	 */
	public boolean hasBbanPrefix() {
		return bbanPrefixPattern != null;
	}
	
	/**
     * 
     * @return
     */
	public String getBankIdentifierPattern() {
		return bankIdentifierPattern;
	}

	/**
	 * 
	 * @return may return <code>null</code>
	 */
	public String getBranchIdentifierPattern() {
		return branchIdentifierPattern;
	}

	/**
	 * 
	 * @return
	 */
	public boolean hasBranchIdentifier() {
		return branchIdentifierPattern != null;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAccountNumberPattern() {
		return accountNumberPattern;
	}

	/**
     * This method simply calls {@link #valueOf(String)} but wraps any {@link IllegalArgumentException} that may be
     * thrown there.
     * 
     * @param cc the name of one of the enum values
     * 
     * @return the {@link CountryCode} enum value representing the supplied name
     * 
     * @throws UnknownCountryCodeException if no enum value equals the supplied name
     */
    public static CountryCode fromString(String cc) {
        try {
            return valueOf(cc);
        } catch (IllegalArgumentException e) {
            throw new UnknownCountryCodeException(cc);
        }
    }
}
