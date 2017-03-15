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

    AD(20, "\\d{4}\\d{4}\\w{12}"), // Andorra 
    AE(19, "\\d{3}\\d{16}"), // United Arab Emirates 
    AL(24, "\\d{8}\\w{16}"), // Albania 
    AT(16, "\\d{5}\\d{11}"), // Austria
    AZ(24, "[A-Z]{4}\\w{20}"), // Azerbaijan 
    BA(16, "\\d{3}\\d{3}\\d{8}\\d{2}"), // Bosnia and Hergegovina 
    BE(12, "\\d{3}\\d{7}\\d{2}"), // Belgium
    BG(18, "[A-Z]{4}\\d{4}\\d{2}\\w{8}"), // Bulgaria
    BH(18, "[A-Z]{4}\\w{14}"), // Bahrain
    BR(25, "\\d{8}\\d{5}\\d{10}[A-Z]\\w"), // Brazil
    BY(24, "\\w{4}\\d{4}\\w{16}"), // Belarus
    CH(17, "\\d{5}\\w{12}"), // Switzerland
    CR(18, "\\d{4}\\d{14}"), // Costa Rica
    CY(24, "\\d{3}\\d{5}\\w{16}"), // Cyprus 
    CZ(20, "\\d{4}\\d{6}\\d{10}"), // Czech Republic
    DE(18, "\\d{8}\\d{10}"), // Germany
    DK(14, "\\d{4}\\d{9}\\d{1}"), // Denmark
    DO(24, "\\w{4}\\d{20}"), // Dominican Republic
    EE(16, "\\d{2}\\d{2}\\d{11}\\d"), // Estonia
    ES(20, "\\d{4}\\d{4}\\d\\d\\d{10}"), // Spain
    FI(14, "\\d{3}\\d{11}"), // Finland
    FO(14, "\\d{4}\\d{9}\\d"), // Faroe Islands
    FR(23, "\\d{5}\\d{5}\\w{11}\\d{2}"), // France
    GB(18, "[A-Z]{4}\\d{6}\\d{8}"), // United Kingdom
    GE(18, "[A-Z]{2}\\d{16}"), // Georgia
    GI(19, "[A-Z]{4}\\w{15}"), // Gibraltar
    GL(14, "\\d{4}\\d{9}\\d"), // Greenland
    GR(23, "\\d{3}\\d{4}\\w{16}"), // Greece
    GT(24, "\\w{4}\\w{20}"), // Guatemala
    HR(17, "\\d{7}\\d{10}"), // Croatia
    HU(24, "\\d{3}\\d{4}\\d\\d{15}\\d"), // Hungary
    IE(18, "[A-Z]{4}\\d{6}\\d{8}"), // Ireland
    IL(19, "\\d{3}\\d{3}\\d{13}"), // Israel
    IQ(19, "[A-Z]{4}\\d{3}\\d{12}"), // Iraq
    IS(22, "\\d{4}\\d{2}\\d{6}\\d{10}"), // Iceland
    IT(23, "[A-Z]\\d{5}\\d{5}\\w{12}"), // Italy
    JO(26, "[A-Z]{4}\\d{4}\\w{18}"), // Jordan
    KW(26, "[A-Z]{4}\\w{22}"), // Kuwait
    KZ(16, "\\d{3}\\w{13}"), // Kazakhstan
    LB(24, "\\d{4}\\w{20}"), // Lebanon
    LC(28, "[A-Z]{4}\\w{24}"), // Saint Lucia
    LI(17, "\\d{5}\\w{12}"), // Liechtenstein
    LT(16, "\\d{5}\\d{11}"), // Lithuania
    LU(16, "\\d{3}\\w{13}"), // Luxembourg
    LV(17, "[A-Z]{4}\\w{13}"), // Latvia
    MC(23, "\\d{5}\\d{5}\\w{11}\\d{2}"), // Monaco
    MD(20, "\\w{2}\\w{18}"), // Moldova
    ME(18, "\\d{3}\\d{13}\\d{2}"), // Montenegro
    MK(15, "\\d{3}\\w{10}\\d{2}"), // Macedonia
    MR(23, "\\d{5}\\d{5}\\d{11}\\d{2}"), // Mauritania
    MT(27, "[A-Z]{4}\\d{5}\\w{18}"), // Malta
    MU(26, "[A-Z]{4}\\d{2}\\d{2}\\d{12}\\d{3}\\w{3}"), // Mauritius
    NL(14, "[A-Z]{4}\\d{10}"), // Netherlands 
    NO(11, "\\d{4}\\d{6}\\d"), // Norway
    PK(20, "[A-Z]{4}\\w{16}"), // Pakistan
    PL(24, "\\d{8}\\d{16}"), // Poland
    PS(25, "[A-Z]{4}\\w{21}"), // Palestine
    PT(21, "\\d{4}\\d{4}\\d{11}\\d{2}"), // Portugal
    QA(25, "[A-Z]{4}\\w{21}"), // Qatar
    RO(20, "[A-Z]{4}\\w{16}"), // Romania
    RS(18, "\\d{3}\\d{13}\\d{2}"), // Serbia
    SA(20, "\\d{2}\\w{18}"), // Saudi Arabia
    SC(27, "[A-Z]{4}\\d{2}\\d{2}\\d{16}[A-Z]{3}"), // Seychelles
    SE(20, "\\d{3}\\d{16}\\d"), // Sweden
    SI(15, "\\d{5}\\d{8}\\d{2}"), // Slovenia
    SK(20, "\\d{4}\\d{6}\\d{10}"), // Slovakia
    SM(23, "[A-Z]\\d{5}\\d{5}\\w{12}"), // San Marino
    ST(21, "\\d{4}\\d{4}\\d{11}\\d{2}"), // Sao Tome and Principe
    SV(24, "[A-Z]{4}\\d{20}"), // El Salvador
    TL(19, "\\d{3}\\d{14}\\d{2}"), // East Timor
    TN(20, "\\d{2}\\d{3}\\d{13}\\d{2}"), // Tunisia
    TR(22, "\\d{5}\\d\\w{16}"), // Turkey
    UA(25, "\\d{6}\\w{19}"), // Ukraine
    VG(20, "[A-Z]{4}\\d{16}"), // Virgin Islands
    XK(16, "\\d{4}\\d{10}\\d{2}"); // Kosovo
    
	/** Country-specific BBAN length. */
    private int bbanLength;

    /** Regular Expression of the BBAN pattern for this country code. */
    private String bbanPattern;
    
    /**
     * @param length country-specific BBAN length
     * @param bbanPattern regular expression describing this country code's BBAN format
     */
    private CountryCode(int bbanLength, String bbanPattern) {
        this.bbanLength = bbanLength;
        this.bbanPattern = bbanPattern;
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
    	return this.name()+"\\d{2}"+bbanPattern;
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
