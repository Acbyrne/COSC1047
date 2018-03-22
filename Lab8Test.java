//COSC1047 Lab8 JUnit Test - Adam Byrne

package javaapplication;

import junit.framework.TestCase;

	public class Lab8Test extends TestCase {
		private Lab8 t;

		// Any method named setUp will be executed before each test.
		protected void setUp() {
			int[] stars = new int[]{1, 1, 2, 3, 3, 3};
			t = new Lab8(stars);
		}

		protected void tearDown() {
		} // tearDown will be executed afterwards

		public void testMostlyPositive() { // All tests are named test[Something]
			assertTrue(t.mostlyPositive());
		}

		public void testMostlyNegative() {
			assertFalse(t.mostlyNegative());
		}
		public void testMixed() {
			assertFalse(t.mixed());
		}
	}

