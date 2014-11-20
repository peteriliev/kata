package test.java;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.Arrays;

import main.java.ShellSort31;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.iliev.peter.guice.GuiceIntegration;
import com.iliev.peter.kata.conventions.ISortTestSet;
import com.iliev.peter.kata.utils.ArrayComparer;
import com.iliev.peter.kata.utils.ITestSetProvider;

@RunWith(GuiceIntegration.class)
public class TestShellSort {

	@Inject
	ITestSetProvider testProvider;

	@Test
	public void test() throws RemoteException
	{
		final ISortTestSet[] sets = testProvider.getAll();

		for (final ISortTestSet set : sets) {
			final Integer[] sortedSet = (Integer[]) set.getSortedSet();
			final Integer[][] unsortedSets = (Integer[][]) set.getUnsortedSets();

			for (final Integer[] unsorted : unsortedSets) {
				System.out
						.printf("Sorted = %s\tunsorted = %s\n", Arrays.toString(sortedSet), Arrays.toString(unsorted));

				ShellSort31.sort(unsorted);
				assertTrue(String.format("Sorting %s failed", Arrays.toString(unsorted)),
						ArrayComparer.areEqualArrays(sortedSet, unsorted));
			}
		}
	}

}
