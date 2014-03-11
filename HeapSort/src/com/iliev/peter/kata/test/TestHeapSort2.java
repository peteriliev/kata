package com.iliev.peter.kata.test;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.iliev.peter.guice.GuiceIntegration;
import com.iliev.peter.kata.HeapSort27;
import com.iliev.peter.kata.conventions.ISortTestSet;
import com.iliev.peter.kata.utils.ArrayComparer;
import com.iliev.peter.kata.utils.ITestSetProvider;

@RunWith(GuiceIntegration.class)
public class TestHeapSort2 {

	@Inject
	ITestSetProvider testProvider;

	@Test
	public void test() throws RemoteException
	{
		ISortTestSet[] sets = testProvider.getAll();

		for (ISortTestSet set : sets) {
			Integer[] sortedSet = (Integer[]) set.getSortedSet();
			Integer[][] unsortedSets = (Integer[][]) set.getUnsortedSets();

			for (Integer[] unsorted : unsortedSets) {
				System.out
						.printf("Sorted = %s\tunsorted = %s\n", Arrays.toString(sortedSet), Arrays.toString(unsorted));
				Integer[] foo = Arrays.copyOf(unsorted, unsorted.length);
				HeapSort27.sort(unsorted);

				assertTrue(
						String.format("Sorting %s failed (was %s, expected %s)", Arrays.toString(foo),
								Arrays.toString(unsorted), Arrays.toString(sortedSet)),
						ArrayComparer.areEqualArrays(sortedSet, unsorted));
			}
		}
	}
}