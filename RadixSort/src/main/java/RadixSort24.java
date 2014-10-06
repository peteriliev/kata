package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RadixSort24 {

	public static int getSignificant(final int number, final int position)
	{
		if (number < 0) {
			throw new IllegalArgumentException("num < 0");
		}

		if (position < 1) {
			throw new IllegalArgumentException("position < 1");
		}

		if (number == 0) {
			return 0;
		}

		final int divisor = (int) Math.pow(NUM_BUCKETS, position - 1);

		return (number / divisor) % NUM_BUCKETS;
	}

	private final static int NUM_BUCKETS = 10;

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		final int maxLen = (int) Math.log10(max - min + 1) + 1;

		final List[] buckets = new ArrayList[NUM_BUCKETS];

		for (int radix = 1; radix <= maxLen; radix++) {
			reset(buckets);
			for (final int i : a) {
				final int significant = getSignificant(i - min, radix);
				buckets[significant].add(i);
			}

			int offset = 0;
			for (final List bucket : buckets) {
				for (final Object obj : bucket) {
					if (null == obj) {
						continue;
					}
					a[offset++] = (Integer) obj;
				}
			}
		}
	}

	private final static void reset(final List[] buckets)
	{
		for (int i = 0; i < buckets.length; i++) {
			if (null == buckets[i]) {
				buckets[i] = new ArrayList<>();
			} else {
				buckets[i].clear();
			}
		}
	}
}