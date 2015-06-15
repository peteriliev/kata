package test.java;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.Arrays;

import main.java.BucketSort39;
import main.java.InsertionSort39;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.iliev.peter.guice.GuiceIntegration;
import com.iliev.peter.kata.conventions.ISortTestSet;
import com.iliev.peter.kata.utils.ArrayComparer;
import com.iliev.peter.kata.utils.ITestSetProvider;

@RunWith(GuiceIntegration.class)
public class BucketSortTest {

	@Inject
	ITestSetProvider testProvider;

	@Test
	public void test1() {
		assertTrue(BucketSort39.calcNumBuckets(1, 100) == 1);
	}

	@Test
	public void test2() {
		assertTrue(BucketSort39.calcNumBuckets(0, 100) == 0);
	}

	@Test
	public void test4() {
		assertTrue(BucketSort39.calcNumBuckets(3, 2) == 2);
	}

	@Test
	public void test5() {
		assertTrue(BucketSort39.calcNumBuckets(2, 2) == 1);
	}

	@Test
	public void test6() {
		assertTrue(BucketSort39.calcNumBuckets(4, 2) == 2);
	}

	@Test
	public void test7() {
		assertTrue(BucketSort39.calcNumBuckets(100, 3) == 34);
	}

	@Test
	public void test8() {
		assertTrue(BucketSort39.calcNumBuckets(101, 50) == 3);
	}

	@Test
	public void testBS() throws RemoteException {
		ISortTestSet[] sets = testProvider.getAll();

		for (ISortTestSet set : sets) {
			Integer[] sortedSet = (Integer[]) set.getSortedSet();
			Integer[][] unsortedSets = (Integer[][]) set.getUnsortedSets();

			for (Integer[] unsorted : unsortedSets) {
				System.out.printf("Sorted = %s\tunsorted = %s\n",
						Arrays.toString(sortedSet), Arrays.toString(unsorted));

				BucketSort39.sort(unsorted);
				assertTrue(
						String.format("Sorting %s failed",
								Arrays.toString(unsorted)),
						ArrayComparer.areEqualArrays(sortedSet, unsorted));
			}
		}
	}

	@Test
	public void testIS() throws RemoteException {
		ISortTestSet[] sets = testProvider.getAll();

		for (ISortTestSet set : sets) {
			Integer[] sortedSet = (Integer[]) set.getSortedSet();
			Integer[][] unsortedSets = (Integer[][]) set.getUnsortedSets();

			for (Integer[] unsorted : unsortedSets) {
				System.out.printf("Sorted = %s\tunsorted = %s\n",
						Arrays.toString(sortedSet), Arrays.toString(unsorted));

				InsertionSort39.sort(unsorted, 0, unsorted.length - 1);
				assertTrue(
						String.format("Sorting %s failed",
								Arrays.toString(unsorted)),
						ArrayComparer.areEqualArrays(sortedSet, unsorted));
			}
		}
	}
}
