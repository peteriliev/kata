import static org.junit.Assert.*;

import org.junit.Test;


public class BSTest {

	@Test
	public void test() {
		int foo = BinarySearch1.search(new Integer[] {},  1);
		assertTrue(foo == Integer.MIN_VALUE);
	}

	@Test
	public void test2() {
		int foo = BinarySearch1.search(new Integer[] {1},  1);
		assertTrue(foo == 0);
	}

	@Test
	public void test3() {
		int foo = BinarySearch1.search(new Integer[] {1, 2},  1);
		assertTrue(foo == 0);
	}

	@Test
	public void test4() {
		int foo = BinarySearch1.search(new Integer[] {0, 1},  1);
		assertTrue(foo == 1);
	}

	@Test
	public void test5() {
		int foo = BinarySearch1.search(new Integer[] {1, 2, 3},  4);
		assertTrue(foo == 0);
	}
}
