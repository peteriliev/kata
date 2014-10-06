package com.iliev.peter.kata.test;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.Arrays;

import main.java.InsertionSort26;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.iliev.peter.guice.GuiceIntegration;
import com.iliev.peter.kata.conventions.ISortTestSet;
import com.iliev.peter.kata.utils.ArrayComparer;
import com.iliev.peter.kata.utils.ITestSetProvider;

@RunWith(GuiceIntegration.class)
public class TestInsertionSort {

	@Inject
	ITestSetProvider testProvider;

	@Test
	public void test_001() throws RemoteException
	{
		ISortTestSet[] sets = testProvider.getAll();

		for (ISortTestSet set : sets) {
			Integer[] sortedSet = (Integer[]) set.getSortedSet();
			Integer[][] unsortedSets = (Integer[][]) set.getUnsortedSets();

			for (Integer[] unsorted : unsortedSets) {
				System.out
						.printf("Sorted = %s\tunsorted = %s\n", Arrays.toString(sortedSet), Arrays.toString(unsorted));

				InsertionSort26.sort(unsorted);
				assertTrue(String.format("Sorting %s failed", Arrays.toString(unsorted)),
						ArrayComparer.areEqualArrays(sortedSet, unsorted));
			}
		}
	}
}
