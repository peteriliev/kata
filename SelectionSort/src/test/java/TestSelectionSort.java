package test.java;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.Arrays;

import main.java.SelectionSort32;
import main.java.SelectionSort33;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.iliev.peter.guice.GuiceIntegration;
import com.iliev.peter.kata.conventions.ISortTestSet;
import com.iliev.peter.kata.utils.ArrayComparer;
import com.iliev.peter.kata.utils.ITestSetProvider;

@RunWith(GuiceIntegration.class)
public class TestSelectionSort {

	@Inject
	ITestSetProvider testProvider;

	@Test
	public void test2() throws RemoteException {
		final ISortTestSet[] allSets = testProvider.getAll();

		for (final ISortTestSet set : allSets) {
			final Integer[] sortedSet = (Integer[]) set.getSortedSet();
			final Integer[][] unsortedSets = (Integer[][]) set.getUnsortedSets();

			for (final Integer[] unsorted : unsortedSets) {
				System.out.printf("Sorted %s \t\t\t\tunsorted %s\n", Arrays.toString(sortedSet), Arrays.toString(unsorted));
				SelectionSort33.sort(unsorted);
				assertTrue(String.format("Sorting %s failed", Arrays.toString(unsorted)), ArrayComparer.areEqualArrays(sortedSet, unsorted));
			}
		}
	}
}
