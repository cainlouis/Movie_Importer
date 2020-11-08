package movies.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import movies.utilities.Utilities;

class UtilitiesTests {
	/**
	 * @author Juan-Carlos Sreng-Flores
	 * Tests the isNumber from Utilities class.
	 * The tests consist on testing for negative numbers, as well as positive numbers.
	 * */
	@Test
	void testUtilitiesIsNumber() {
		String s;
		//Test for true cases.
		s = "5";
		assertEquals(true, Utilities.isNumber(s));
		s="126546864";
		assertEquals(true, Utilities.isNumber(s));
		s="-2365136";
		assertEquals(true, Utilities.isNumber(s));
		s="0";
		assertEquals(true, Utilities.isNumber(s));
		//Tests for false cases.
		s = "54674564674 ";
		assertEquals(false, Utilities.isNumber(s));
		s = "34543jk31345";
		assertEquals(false, Utilities.isNumber(s));
		s = "-31123jk35";
		assertEquals(false, Utilities.isNumber(s));
		s="-0";
		assertEquals(true, Utilities.isNumber(s));
	}

}
