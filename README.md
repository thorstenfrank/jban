# jban
Java IBAN library.

Very simple, straight-forward. Validates existing IBAN numbers, generates check digits based on country code and the
BBAN (country-specific basic bank account number).

I needed this specific functionality in another project, so this is basically collateral.

## Usage

```java
  // using a complete IBAN string - this will validate the IBAN string
  Iban iban = new Iban("MT84 MALT 0110 0001 2345 MTLC AST0 01S");

  // or using the country code and BBAN - in this case, the check digits are calculated
  Iban iban = new Iban(CountryCode.MT, "MALT 0110 0001 2345 MTLC AST0 01S");

  // the three basic building blocks are now available separately
  iban.getCountryCode(); // CountryCode.MT - Malta
  iban.getChecksum() // 84
  iban.getBban() // MALT011000012345MTLCAST001S
