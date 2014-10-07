package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RadixSort30 {

	public static void sort(final Integer[] a) {
		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		final int maxNum = max - min;
		final int maxLen = (int) Math.log10(maxNum) + 1;

		final List<Integer>[] buckets = new List[10];

		for (int i = 1; i <= maxLen; i++) {
			reset(buckets);
			
			for (final int ii : a)
			{
				final int significant = getSignificant(ii - min, i);
				buckets[significant].add(ii);
			}
			
			int offset = 0;
			for (final List<Integer> bucket : buckets)
			{
				for (final int foo : bucket)
				{
					a[offset++] = foo;
				}
			}
		}
	}

	private static final void reset(final List[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == null) {
				buckets[i] = new ArrayList<Integer>();
			} else {
				buckets[i].clear();
			}
		}
	}

	public static int getSignificant(final int number, final int position) {
		if (number < 0) {
			throw new IllegalArgumentException("num < 0");
		}

		if (position < 1) {
			throw new IllegalArgumentException("position < 1");
		}

		final int divisor = (int) Math.pow(10, position - 1);

		return (number / divisor) % 10;
	}
}
