package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RadixSort25 {

	public static int getSignificant(final int num, final int position)
	{
		if (num < 0) {
			throw new IllegalArgumentException("num < 0");
		}

		if (position < 1) {
			throw new IllegalArgumentException("position < 1");
		}

		final int divisor = (int) Math.pow(NUM_BUCKETS, position - 1);

		return (num / divisor) % NUM_BUCKETS;
	}

	private static final int NUM_BUCKETS = 10;

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));

		final int maxLen = (int) Math.log10(max - min) + 1;

		final List[] buckets = new List[NUM_BUCKETS];
		for (int radix = 1; radix <= maxLen; radix++) {
			resetList(buckets);

			for (final Integer i : a) {
				final int num = getSignificant(i - min, radix);
				buckets[num].add(i);
			}

			int ptr = 0;
			for (final List<Integer> bucket : buckets) {
				for (final Object obj : bucket) {
					a[ptr++] = (Integer) obj;
				}
			}
		}
	}

	private static void resetList(final List[] buckets)
	{
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == null) {
				buckets[i] = new ArrayList<Integer>();
			} else {
				buckets[i].clear();
			}
		}
	}
}
