package test.java;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.Arrays;

import main.java.FlagSort31;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.iliev.peter.guice.GuiceIntegration;
import com.iliev.peter.kata.conventions.ISortTestSet;
import com.iliev.peter.kata.utils.ArrayComparer;
import com.iliev.peter.kata.utils.ITestSetProvider;

@RunWith(GuiceIntegration.class)
public class FlagSortTest {

	@Inject
	ITestSetProvider testProvider;

	@Test
	public void test_001() throws Exception {
		assertTrue(FlagSort31.getDigit(1, 1) == 1);
	}

	@Test
	public void test_002() throws Exception {
		assertTrue(FlagSort31.getDigit(1, 10) == 0);
	}

	@Test
	public void test_003() throws Exception {
		assertTrue(FlagSort31.getDigit(11, 10) == 1);
	}

	@Test
	public void test_004() throws Exception {
		assertTrue(FlagSort31.getDigit(777, 100) == 7);
	}

	@Test
	public void test_006() throws Exception {
		assertTrue(FlagSort31.getDigit(777, 1000) == 0);
	}

	@Test
	public void test_007() throws Exception {
		assertTrue(FlagSort31.getDigit(770, 1) == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_008() throws Exception {
		FlagSort31.getMaxLength(null);
	}

	@Test
	public void test_009() throws Exception {
		assertTrue(FlagSort31.getMaxLength(new Integer[0]) == 0);
	}

	@Test
	public void test_0091() throws Exception {
		assertTrue(FlagSort31.getMaxLength(new Integer[] { 1 }) == 1);
	}

	@Test
	public void test() throws RemoteException {
		ISortTestSet[] sets = testProvider.getAll();

		for (ISortTestSet set : sets) {
			Integer[] sortedSet = (Integer[]) set.getSortedSet();
			Integer[][] unsortedSets = (Integer[][]) set.getUnsortedSets();

			for (Integer[] unsorted : unsortedSets) {
				System.out.printf("Sorted = %s\tunsorted = %s\n", Arrays.toString(sortedSet), Arrays.toString(unsorted));

				FlagSort31.sort(unsorted);
				assertTrue(String.format("Sorting %s failed", Arrays.toString(unsorted)), ArrayComparer.areEqualArrays(sortedSet, unsorted));
			}
		}
	}
}
