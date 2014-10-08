package test.java;

import static org.junit.Assert.assertTrue;
import main.java.Decimal2Roman30;

import org.junit.Test;

public class Decimal2RomanTest {

	@Test
	public void test0() {
		assertTrue("".equalsIgnoreCase(Decimal2Roman30.foo(0)));
	}

	@Test
	public void test1() {
		assertTrue("MCMLIV".equalsIgnoreCase(Decimal2Roman30.foo(1954)));
	}

	@Test
	public void test2() {
		assertTrue("MCMXC".equalsIgnoreCase(Decimal2Roman30.foo(1990)));
	}

	@Test
	public void test3() {
		assertTrue("MMVIII".equalsIgnoreCase(Decimal2Roman30.foo(2008)));
	}

}
