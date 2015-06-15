package test.java;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.Arrays;

import main.java.RadixSort39;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.iliev.peter.guice.GuiceIntegration;
import com.iliev.peter.kata.conventions.ISortTestSet;
import com.iliev.peter.kata.utils.ArrayComparer;
import com.iliev.peter.kata.utils.ITestSetProvider;

@RunWith(GuiceIntegration.class)
public class RadixSortTest {

	@Inject
	ITestSetProvider testProvider;

	@Test
	public void testDirect() {
		System.out.println(Math.pow(10, 1));
	}

	@Test
	public void testLS1() {
		int ls = RadixSort39.getSignificant(1, 1);
		assertTrue(ls == 1);
	}

	@Test
	public void testLS2() {
		int ls = RadixSort39.getSignificant(0, 1);
		assertTrue(ls == 0);
	}

	@Test
	public void testLS9() {
		int ls = RadixSort39.getSignificant(9, 1);
		assertTrue(ls == 9);
	}

	@Test
	public void testLS10() {
		int ls = RadixSort39.getSignificant(10, 2);
		assertTrue(ls == 1);
	}

	@Test
	public void testLS11() {
		int ls = RadixSort39.getSignificant(9, 2);
		assertTrue(ls == 0);
	}

	@Test
	public void testLS12() {
		int ls = RadixSort39.getSignificant(234, 2);
		assertTrue(ls == 3);
	}

	@Test
	public void testLS13() {
		int ls = RadixSort39.getSignificant(234, 3);
		assertTrue(ls == 2);
	}

	@Test
	public void testLS999() {
		int ls = RadixSort39.getSignificant(999, 1);
		assertTrue(ls == 9);
	}

	@Test
	public void testLS9991() {
		int ls = RadixSort39.getSignificant(999, 4);
		assertTrue(ls == 0);
	}

	@Test
	public void testRSort() throws RemoteException {
		ISortTestSet[] sets = testProvider.getAll();

		for (ISortTestSet set : sets) {
			Integer[] sortedSet = (Integer[]) set.getSortedSet();
			Integer[][] unsortedSets = (Integer[][]) set.getUnsortedSets();

			for (Integer[] unsorted : unsortedSets) {
				System.out.printf("Sorted = %s\tunsorted = %s\n",
						Arrays.toString(sortedSet), Arrays.toString(unsorted));

				RadixSort39.sort(unsorted);
				assertTrue(
						String.format("Sorting %s failed",
								Arrays.toString(unsorted)),
						ArrayComparer.areEqualArrays(sortedSet, unsorted));
			}
		}
	}
}
