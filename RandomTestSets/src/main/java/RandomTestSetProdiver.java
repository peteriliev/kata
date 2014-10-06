package main.java;

import static main.java.Constants.MAX_SETS;
import static main.java.Constants.MIN_SETS;

import java.rmi.RemoteException;
import java.util.Random;

import com.iliev.peter.kata.conventions.ISortTestSet;
import com.iliev.peter.kata.utils.ITestSetProvider;

public class RandomTestSetProdiver implements ITestSetProvider {

	private final Random rnd = new Random(System.currentTimeMillis());

	@Override
	public ISortTestSet[] getAll() throws RemoteException
	{
		final int numSets = MIN_SETS + rnd.nextInt(MAX_SETS - MIN_SETS + 1);

		final ISortTestSet[] result = new RandomSet[numSets];
		for (int i = 0; i < numSets; i++) {
			result[i] = new RandomSet();
		}

		return result;
	}
}