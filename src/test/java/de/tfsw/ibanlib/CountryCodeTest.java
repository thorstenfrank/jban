/**
 * 
 */
package de.tfsw.ibanlib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.tfsw.iban.CountryCode;

/**
 * Tests the {@link CountryCode} configuration of BBAN and IBAN regex patterns.
 * 
 * All test values and examples have been copied directly from the IBAN Registry document.
 *
 */
public class CountryCodeTest {

	@Test
	public void test() {
		doTestCountryCode(CountryCode.AD, 20, "00012030200359100100", "AD1200012030200359100100", true);
		doTestCountryCode(CountryCode.AE, 19, "0331234567890123456", "AE070331234567890123456");
		doTestCountryCode(CountryCode.AL, 24, "212110090000000235698741", "AL47212110090000000235698741", false);
		doTestCountryCode(CountryCode.AT, 16, "1904300234573201", "AT611904300234573201");
		doTestCountryCode(CountryCode.AZ, 24, "NABZ00000000137010001944", "AZ21NABZ00000000137010001944");
		doTestCountryCode(CountryCode.BA, 16, "1990440001200279", "BA391290079401028494", true);
		doTestCountryCode(CountryCode.BE, 12, "539007547034", "BE68539007547034");
		doTestCountryCode(CountryCode.BG, 18, "BNBG96611020345678", "BG80BNBG96611020345678", true);
		doTestCountryCode(CountryCode.BH, 18, "BMAG00001299123456", "BH67BMAG00001299123456");
		doTestCountryCode(CountryCode.BR, 25, "00360305000010009795493P1", "BR1800360305000010009795493C1", true);
		doTestCountryCode(CountryCode.BY, 24, "NBRB3600000000000Z00AB00", "BY13NBRB3600900000002Z00AB00");
		doTestCountryCode(CountryCode.CH, 17, "00762011623852957", "CH9300762011623852957");
		doTestCountryCode(CountryCode.CR, 18, "015202001026284066", "CR05015202001026284066");
		doTestCountryCode(CountryCode.CY, 24, "002001280000001200527600", "CY17002001280000001200527600", true);
		doTestCountryCode(CountryCode.CZ, 20, "08000000192000145399", "CZ6508000000192000145399");
		doTestCountryCode(CountryCode.DE, 18, "370400440532013000", "DE89370400440532013000");
		doTestCountryCode(CountryCode.DK, 14, "00400440116243", "DK5000400440116243");
		doTestCountryCode(CountryCode.DO, 24, "BAGR00000001212453611324", "DO28BAGR00000001212453611324");
		doTestCountryCode(CountryCode.EE, 16, "2200221020145685", "EE382200221020145685");
		doTestCountryCode(CountryCode.ES, 20, "21000418450200051332", "ES9121000418450200051332", true);
		doTestCountryCode(CountryCode.FI, 14, "12345600000785", "FI2112345600000785");
		doTestCountryCode(CountryCode.FO, 14, "64600001631634", "FO6264600001631634");
		doTestCountryCode(CountryCode.FR, 23, "20041010050500013M02606", "FR1420041010050500013M02606");
		doTestCountryCode(CountryCode.GB, 18, "NWBK60161331926819", "GB29NWBK60161331926819", true);
		doTestCountryCode(CountryCode.GE, 18, "NB0000000101904917", "GE29NB0000000101904917");
		doTestCountryCode(CountryCode.GI, 19, "NWBK000000007099453", "GI75NWBK000000007099453");
		doTestCountryCode(CountryCode.GL, 14, "64710001000206", "GL8964710001000206");
		doTestCountryCode(CountryCode.GR, 23, "01101250000000012300695", "GR1601101250000000012300695", true);
		doTestCountryCode(CountryCode.GT, 24, "TRAJ01020000001210029690", "GT82TRAJ01020000001210029690");
		doTestCountryCode(CountryCode.HR, 17, "10010051863000160", "HR1210010051863000160");
		doTestCountryCode(CountryCode.HU, 24, "117730161111101800000000", "HU42117730161111101800000000",true);
		doTestCountryCode(CountryCode.IE, 18, "AIBK93115212345678", "IE29AIBK93115212345678", true);
		doTestCountryCode(CountryCode.IL, 19, "0108000000099999999", "IL620108000000099999999", true);
		doTestCountryCode(CountryCode.IQ, 19, "NBIQ850123456789012", "IQ98NBIQ850123456789012", true);
		doTestCountryCode(CountryCode.IS, 22, "0159260076545510730339", "IS140159260076545510730339", true);
		doTestCountryCode(CountryCode.IT, 23, "X0542811101000000123456", "IT60X0542811101000000123456", true);
		doTestCountryCode(CountryCode.JO, 26, "CBJO0010000000000131000302", "JO94CBJO0010000000000131000302");
		doTestCountryCode(CountryCode.KW, 26, "CBKU0000000000001234560101", "KW81CBKU0000000000001234560101");
		doTestCountryCode(CountryCode.KZ, 16, "125KZT5004100100", "KZ86125KZT5004100100");
		doTestCountryCode(CountryCode.LB, 24, "099900000001001901229114", "LB62099900000001001901229114");
		doTestCountryCode(CountryCode.LC, 28, "HEMM000100010012001200023015", "LC55HEMM000100010012001200023015");
		doTestCountryCode(CountryCode.LI, 17, "088100002324013AA", "LI21088100002324013AA");
		doTestCountryCode(CountryCode.LT, 16, "1000011101001000", "LT121000011101001000");
		doTestCountryCode(CountryCode.LU, 16, "0019400644750000", "LU280019400644750000");
		doTestCountryCode(CountryCode.LV, 17, "BANK0000435195001", "LV80BANK0000435195001");
		doTestCountryCode(CountryCode.MC, 23, "11222000010123456789030", "MC5811222000010123456789030", true);
		doTestCountryCode(CountryCode.MD, 20, "AG000225100013104168", "MD24AG000225100013104168");
		doTestCountryCode(CountryCode.ME, 18, "505000012345678951", "ME25505000012345678951");
		doTestCountryCode(CountryCode.MK, 15, "250120000058984", "MK07250120000058984");
		doTestCountryCode(CountryCode.MR, 23, "00020001010000123456753", "MR1300020001010000123456753", true);
		doTestCountryCode(CountryCode.MT, 27, "MALT011000012345MTLCAST001S", "MT84MALT011000012345MTLCAST001S", true);
		doTestCountryCode(CountryCode.MU, 26, "BOMM0101101030300200000MUR", "MU17BOMM0101101030300200000MUR", true);
		doTestCountryCode(CountryCode.NL, 14, "ABNA0417164300", "NL91ABNA0417164300");
		doTestCountryCode(CountryCode.NO, 11, "86011117947", "NO9386011117947");
		doTestCountryCode(CountryCode.PK, 20, "SCBL0000001123456702", "PK36SCBL0000001123456702");
		doTestCountryCode(CountryCode.PL, 24, "109010140000071219812874", "PL61109010140000071219812874");
		doTestCountryCode(CountryCode.PS, 25, "PALS000000000400123456702", "PS92PALS000000000400123456702");
		doTestCountryCode(CountryCode.PT, 21, "000201231234567890154", "PT50000201231234567890154");
		doTestCountryCode(CountryCode.QA, 25, "DOHB00001234567890ABCDEFG", "QA58DOHB00001234567890ABCDEFG");
		doTestCountryCode(CountryCode.RO, 20, "AAAA1B31007593840000", "RO49AAAA1B31007593840000");
		doTestCountryCode(CountryCode.RS, 18, "260005601001611379", "RS35260005601001611379");
		doTestCountryCode(CountryCode.SA, 20, "80000000608010167519", "SA0380000000608010167519");
		doTestCountryCode(CountryCode.SC, 27, "SSCB11010000000000001497USD", "SC18SSCB11010000000000001497USD", true);
		doTestCountryCode(CountryCode.SE, 20, "50000000058398257466", "SE4550000000058398257466");
		doTestCountryCode(CountryCode.SI, 15, "263300012039086", "SI56263300012039086");
		doTestCountryCode(CountryCode.SK, 20, "12000000198742637541", "SK3112000000198742637541");
		doTestCountryCode(CountryCode.SM, 23, "U0322509800000000270100", "SM86U0322509800000000270100", true);
		doTestCountryCode(CountryCode.ST, 21, "000200010192194210112", "ST68000200010192194210112", true);
		doTestCountryCode(CountryCode.SV, 24, "CENR00000000000000700025", "SV62CENR00000000000000700025");
		doTestCountryCode(CountryCode.TL, 19, "0080012345678910157", "TL380080012345678910157");
		doTestCountryCode(CountryCode.TN, 20, "10006035183598478831", "TN5910006035183598478831", true);
		doTestCountryCode(CountryCode.TR, 22, "0006100519786457841326", "TR330006100519786457841326");
		doTestCountryCode(CountryCode.UA, 25, "3223130000026007233566001", "UA213223130000026007233566001");
		doTestCountryCode(CountryCode.VG, 20, "VPVG0000012345678901", "VG96VPVG0000012345678901");
		doTestCountryCode(CountryCode.XK, 16, "1212012345678906", "XK051212012345678906", true);
	}

	private void doTestCountryCode(CountryCode code, int expectedBbanLength, String bbanToTest, String ibanToTest) {
		doTestCountryCode(code, expectedBbanLength, bbanToTest, ibanToTest, false);
	}
	
	private void doTestCountryCode(CountryCode code, int expectedBbanLength, String bbanToTest, String ibanToTest, boolean hasBranchCode) {
		assertEquals(
				String.format("Country Code %s does not have expected BBAN length: %d, instead: %d", code.toString(), expectedBbanLength, code.getBbanLength()), 
				expectedBbanLength, code.getBbanLength());
		assertTrue("Country Code BBAN pattern error: " + code.toString() + " : " + code.getBbanPattern(), bbanToTest.matches(code.getBbanPattern()));
		assertTrue("Country Code IBAN pattern error: " + code.toString(), ibanToTest.matches(code.getIbanPattern()));
		assertEquals("Country Code Branch Code mismatch: " + code.toString(), hasBranchCode, code.hasBranchIdentifier());
	}
}

