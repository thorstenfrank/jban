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
 * @author Thorsten Frank
 */
public enum CountryCode {

    AD(20), AE(19), AL(24), AT(16), AZ(24), BA(16), BE(12), BG(18), BH(18), BR(25), BY(28), CH(17), CR(17), CY(24), 
    CZ(20), DE(18), DK(14), DO(24), EE(16), ES(20), FI(14), FO(18), FR(23), GB(18), GE(18), GI(19), GL(18), GR(23), 
    GT(24), HR(17), HU(24), IE(18), IL(19), IS(22), IT(23), JO(26), KW(26), KZ(16), LB(24), LC(28), LI(17), LT(16), 
    LU(16), LV(17), MC(23), MD(20), ME(18), MK(15), MR(23), MT(27), MU(26), NL(14), NO(11), PK(20), PL(24), PS(25), 
    PT(21), QA(25), RO(20), RS(18), SA(20), SC(27), SE(20), SI(15), SK(20), SM(23), ST(21), TL(19), TN(20), TR(22), 
    UA(25), VG(20), XK(16);
    
	/** Country-specific BBAN length. */
    private int bbanLength;

    /**
     * @param length country-specific BBAN length
     */
    private CountryCode(int bbanLength) {
        this.bbanLength = bbanLength;
    }

    /**
     * 
     * @return the length of a BBAN of this country
     */
    public int getBbanLength() {
        return bbanLength;
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
