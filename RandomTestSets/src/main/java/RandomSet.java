package main.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import com.iliev.peter.kata.conventions.ISortTestSet;

public class RandomSet implements ISortTestSet {

	private final Random rnd;
	private final Integer[] sorted;
	private final Integer[][] unsorted;

	public RandomSet() {
		rnd = new Random(System.currentTimeMillis());
		final int numElem = rnd.nextInt(Constants.MAX_NUM_ELEM + 1);
		final int permutations = 10;//factoriel(numElem);

		sorted = new Integer[numElem];
		for (int i = 0; i < numElem; i++) {
			sorted[i] = rnd.nextInt(Constants.MAX_RANGE - Constants.MIN_RANGE + 1) + Constants.MIN_RANGE;
		}

		Collections.sort(Arrays.asList(sorted));

		unsorted = new Integer[permutations][];
		for (int i = 0; i < permutations; i++) {
			unsorted[i] = Arrays.copyOf(sorted, numElem);
			Collections.shuffle(Arrays.asList(unsorted[i]), rnd);
		}
	}
	
	private static final int factoriel(final int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n < 0");
		}
		
		int result = 1;
		for (int i = n; i > 0; i--) {
			result *= n;
		}
		
		return result;
	}

	@Override
	public Integer[] getSortedSet()
	{
		return sorted;
	}

	@Override
	public Integer[][] getUnsortedSets()
	{
		return unsorted;
	}
}
