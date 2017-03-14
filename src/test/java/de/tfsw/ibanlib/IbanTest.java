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
package de.tfsw.ibanlib;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.tfsw.iban.BbanValidationException;
import de.tfsw.iban.CountryCode;
import de.tfsw.iban.Iban;
import de.tfsw.iban.InvalidChecksumException;
import de.tfsw.iban.UnknownCountryCodeException;

/**
 * @author Thorsten Frank
 *
 */
public class IbanTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void testIbanConstructorNull() {
        new Iban(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIbanConstructorEmpty() {
        new Iban("");
    }
    
    @Test(expected = BbanValidationException.class)
    public void testIbanConstructorTooLong() {
        new Iban("DE445001051754073249317891237892378");
    }
    
    @Test(expected = UnknownCountryCodeException.class)
    public void testIbanConstructorInvalidCountryCode() {
        new Iban("ZZ445001051754073249317891237892378");
    }
    
    @Test(expected = BbanValidationException.class)
    public void testChecksumValidationIllegalCharacter() {
        new Iban("DE44 5001 0517 54$7 3249 31");
    }
    
    @Test
    public void testIbanConstructor() {
        Iban iban = new Iban("DE44 5001 0517 5407 3249 31");
        assertEquals(CountryCode.DE, iban.getCountryCode());
        assertEquals("500105175407324931", iban.getBban());
        assertEquals("44", iban.getChecksum());
        
        iban = new Iban("VG96VPVG0000012345678901");
        assertEquals(CountryCode.VG, iban.getCountryCode());
        assertEquals("VPVG0000012345678901", iban.getBban());
        assertEquals("96", iban.getChecksum());
        
        iban = new Iban("MT84 MALT 0110 0001 2345 MTLC AST0 01S");
        assertEquals(CountryCode.MT, iban.getCountryCode());
        assertEquals("MALT011000012345MTLCAST001S", iban.getBban());
        assertEquals("84", iban.getChecksum());        
    }
    
    @Test(expected = InvalidChecksumException.class)
    public void testIbanConstructorInvalidChecksum() {
        new Iban("DE17 5001 0517 5407 3249 31");
    }
    
    @Test(expected = BbanValidationException.class)
    public void testIbanConstructorBbanTooLong() {
        new Iban("DE17 5001 0517 5407 3249 310");
    }

    @Test(expected = BbanValidationException.class)
    public void testIbanConstructorBbanTooShort() {
        new Iban("DE17 5001 0517 5407 3249 3");
    }
    
    @Test(expected = BbanValidationException.class)
    public void testCompositeConstructorBbanTooLong() {
        new Iban(CountryCode.DE, "5001 0517 5407 3249 310");
    }
    
    @Test
    public void testCompositeConstructor() {
        Iban iban = new Iban(CountryCode.DE, "5001 0517 5407 3249 31");
        assertEquals(CountryCode.DE, iban.getCountryCode());
        assertEquals("44", iban.getChecksum());
        assertEquals("500105175407324931", iban.getBban());
        
        // leading and trailing whitespace
        iban = new Iban(CountryCode.LV, " BANK 0000 4351 9500 1 ");
        assertEquals(CountryCode.LV, iban.getCountryCode());
        assertEquals("80", iban.getChecksum());
        assertEquals("BANK0000435195001", iban.getBban());
    }
    
    @Test
    public void testGetPrintFormat() {
        Iban iban = new Iban("XK051212012345678906");
        assertEquals("XK05 1212 0123 4567 8906", iban.getPrintFormat());
        
        iban = new Iban(CountryCode.JO, "CBJO0010000000000131000302");
        assertEquals("JO94 CBJO 0010 0000 0000 0131 0003 02", iban.getPrintFormat());
    }
}