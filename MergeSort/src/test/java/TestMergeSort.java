package test.java;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.Arrays;

import main.java.MergeSort30;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.iliev.peter.guice.GuiceIntegration;
import com.iliev.peter.kata.conventions.ISortTestSet;
import com.iliev.peter.kata.utils.ArrayComparer;
import com.iliev.peter.kata.utils.ITestSetProvider;

@RunWith(GuiceIntegration.class)
public class TestMergeSort {

	@Inject
	ITestSetProvider testProvider;

	@Test
	public void test() throws RemoteException {
		ISortTestSet[] allSets = testProvider.getAll();

		for (ISortTestSet set : allSets) {
			Integer[] sortedSet = (Integer[]) set.getSortedSet();
			Integer[][] unsortedSets = (Integer[][]) set.getUnsortedSets();

			for (Integer[] unsorted : unsortedSets) {
				System.out.printf("Sorted %s \t\t\t\tunsorted %s\n",
						Arrays.toString(sortedSet), Arrays.toString(unsorted));
				MergeSort30.sort(unsorted);
				assertTrue(
						String.format("Sorting %s failed",
								Arrays.toString(unsorted)),
						ArrayComparer.areEqualArrays(sortedSet, unsorted));
			}
		}
	}
}
