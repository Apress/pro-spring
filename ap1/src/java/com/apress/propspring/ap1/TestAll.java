/*
 * Created on 06-Nov-2004
 */
package com.apress.propspring.ap1;

import junit.framework.TestCase;


/**
 * @author janm
 */
public class TestAll extends TestCase {

	private static double sqrt(double d) {
		if (d < 0) throw new IllegalArgumentException("ffo");
		if (Double.isNaN(d)) throw new IllegalArgumentException("bar");
		return Math.sqrt(d);
	}
	
	public void testFoo() {
		
	}
	

	public void testSqrt() {
		try {
			sqrt(-1);
			fail("This function returns only real results");
		} catch (IllegalArgumentException expected) {
			// OK
		}

		try {
			sqrt(Double.NaN);
			fail("This function cannot take +/-NaN as asgument");
		} catch (IllegalArgumentException expected) {
			// OK
		}

		assertEquals(3.0, sqrt(9), 0);
	}
	
}
