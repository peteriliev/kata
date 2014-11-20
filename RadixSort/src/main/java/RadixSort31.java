package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RadixSort31 {

	private static final int NUM_BUCKETS = 10;

	public static int getSignificant(final int number, final int radix) {
		if (number < 0) {
			throw new IllegalArgumentException("Number < 0");
		}

		if (radix < 1) {
			throw new IllegalArgumentException("Radix < 1");
		}

		final int divisor = (int) Math.pow(NUM_BUCKETS, radix - 1);

		return (number / divisor) % NUM_BUCKETS;
	}

	public static void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		final int maxNormalized = max - min + 1;
		final int maxLen = (int) Math.log10(maxNormalized) + 1;

		final List<Integer>[] buckets = new ArrayList[NUM_BUCKETS];

		for (int radix = 1; radix <= maxLen; radix++) {
			reset(buckets);

			for (final int i : a) {
				final int num = getSignificant(i - min, radix);
				buckets[num].add(i);
			}

			int offset = 0;
			for (final List<Integer> bucket : buckets) {
				for (final int i : bucket) {
					a[offset++] = i;
				}
			}
		}
	}

	private static final void reset(final List<Integer>[] buckets) {
		for (int i = 0; i < NUM_BUCKETS; i++) {
			if (buckets[i] == null) {
				buckets[i] = new ArrayList<Integer>();
			} else {
				buckets[i].clear();
			}
		}
	}
}
