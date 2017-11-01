package org.coding.stringUtil;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void testApp() {
		App app = new App();
		assertEquals( app.convertString("Automotive"),"A6e");
	}
}
