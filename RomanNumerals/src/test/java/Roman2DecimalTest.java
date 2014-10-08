package test.java;

import static org.junit.Assert.assertTrue;
import main.java.Roman2Decimal30;

import org.junit.Test;

public class Roman2DecimalTest {

	@Test
	public void test0() {
		assertTrue(0 == Roman2Decimal30.foo(""));
	}

	@Test
	public void test1() {
		assertTrue(1 == Roman2Decimal30.foo("I"));
	}

	@Test
	public void test2() {
		assertTrue(2 == Roman2Decimal30.foo("II"));
	}

	@Test
	public void test3() {
		assertTrue(3 == Roman2Decimal30.foo("III"));
	}

	@Test
	public void test4() {
		assertTrue(4 == Roman2Decimal30.foo("IV"));
	}

	@Test
	public void test5() {
		assertTrue(5 == Roman2Decimal30.foo("V"));
	}

	@Test
	public void test9() {
		assertTrue(9 == Roman2Decimal30.foo("IX"));
	}

	@Test
	public void test10() {
		assertTrue(10 == Roman2Decimal30.foo("X"));
	}

	@Test
	public void test11() {
		assertTrue(11 == Roman2Decimal30.foo("XI"));
	}

	@Test
	public void test20() {
		assertTrue(20 == Roman2Decimal30.foo("XX"));
	}

	@Test
	public void test30() {
		assertTrue(30 == Roman2Decimal30.foo("XXX"));
	}

	@Test
	public void test40() {
		assertTrue(40 == Roman2Decimal30.foo("XL"));
	}

	@Test
	public void test50() {
		assertTrue(50 == Roman2Decimal30.foo("L"));
	}

	@Test
	public void test90() {
		assertTrue(90 == Roman2Decimal30.foo("XC"));
	}

	@Test
	public void test100() {
		assertTrue(100 == Roman2Decimal30.foo("C"));
	}

	@Test
	public void test400() {
		assertTrue(400 == Roman2Decimal30.foo("CD"));
	}

	@Test
	public void test500() {
		assertTrue(500 == Roman2Decimal30.foo("D"));
	}

	@Test
	public void test900() {
		assertTrue(900 == Roman2Decimal30.foo("CM"));
	}

	@Test
	public void test1000() {
		assertTrue(1000 == Roman2Decimal30.foo("M"));
	}

	@Test
	public void test1954() {
		assertTrue(1954 == Roman2Decimal30.foo("MCMLIV"));
	}

	@Test
	public void test1990() {
		assertTrue(1990 == Roman2Decimal30.foo("MCMXC"));
	}

	@Test
	public void test2008() {
		assertTrue(2008 == Roman2Decimal30.foo("MMVIII"));
	}
}
