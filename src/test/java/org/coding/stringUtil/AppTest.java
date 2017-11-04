package org.coding.stringUtil;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Before
	public void before() {
		App.considerOnlyAscii = false;
	}

	@Test
	public void testApp() {

		assertEquals("", App.convertString("")); // empty
		assertEquals("", App.convertString(null)); // null string
		assertEquals(" ", App.convertString(" ")); // single space
		assertEquals("     ", App.convertString("     ")); // multiple spaces

		assertEquals("A6e", App.convertString("Automotive"));
		assertEquals("T2s i0s m0y f4d B1b", App.convertString("This is my friend Bob"));
		assertEquals("T2s123i0s12312m0y$%!#@#$$f4d B1b", App.convertString("Ttttis123is12312my$%!#@#$$friend Bob"));
		assertEquals("L2s", App.convertString("Lets"));
		assertEquals("L", App.convertString("L"));
		assertEquals("L0", App.convertString("L0"));
		assertEquals("L1L0", App.convertString("LLL0"));
		assertEquals("L2L p4q", App.convertString("LababababL paberaberq"));

	}

	@Test
	public void testModifiedStringFunction() {
		assertEquals(App.getModifiedString("Automotive", 0, 9), "A6e");
		assertEquals(App.getModifiedString("a", 0, 0), "a");
		assertEquals(App.getModifiedString("aa", 0, 1), "a0a");
		assertEquals(App.getModifiedString("aaa", 0, 2), "a1a"); // 3 char string
		assertEquals(App.getModifiedString("aaa", 5, 10), ""); // start >= string length
		assertEquals(App.getModifiedString("aaa", 0, 21), ""); // end >= string length
		assertEquals(App.getModifiedString("", 0, 21), ""); // empty string
		assertEquals(App.getModifiedString(null, 0, 21), ""); // null string
	}
}
