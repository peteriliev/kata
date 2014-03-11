package com.iliev.peter.kata.utils.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iliev.peter.kata.utils.ArrayComparer;

public class UtilTest {

	@Test
	public void test_bothNullArgs() {
		assertFalse(ArrayComparer.areEqualArrays(null, null));
	}

	@Test
	public void test_2ndNullArgs() {
		assertFalse(ArrayComparer.areEqualArrays(null, new Integer[] {}));
	}
	
	@Test
	public void test_firstNullArgs() {
		assertFalse(ArrayComparer.areEqualArrays(new Integer[] {}, null));
	}

	@Test
	public void test_zeroLength() {
		assertTrue(ArrayComparer.areEqualArrays(new Integer[] {}, new Integer[] {}));
	}

	@Test
	public void test_lengthOneEqual() {
		assertTrue(
				ArrayComparer.areEqualArrays(
						new Integer[] { Integer.MAX_VALUE },
						new Integer[] { Integer.MAX_VALUE }));
	}

	@Test
	public void test_lengthOneNotEqual() {
		assertFalse(
				ArrayComparer.areEqualArrays(
						new Integer[] { Integer.MIN_VALUE },
						new Integer[] { Integer.MAX_VALUE }));
	}

	@Test
	public void test_lengthTwoNotEqual() {
		assertFalse(
				ArrayComparer.areEqualArrays(
						new Integer[] { Integer.MIN_VALUE, Integer.MAX_VALUE },
						new Integer[] { Integer.MAX_VALUE, Integer.MIN_VALUE }));
	}

	@Test
	public void test_lengthTwoEqual() {
		assertTrue(
				ArrayComparer.areEqualArrays(
						new Integer[] { Integer.MIN_VALUE, Integer.MAX_VALUE },
						new Integer[] { Integer.MIN_VALUE, Integer.MAX_VALUE }));
	}
}
