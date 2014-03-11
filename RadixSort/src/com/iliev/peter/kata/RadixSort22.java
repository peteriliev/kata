package com.iliev.peter.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RadixSort22 {

	private final static int NUM_BUCKETS = 10;

	public static int getSignificant(final int num, final int radix)
	{
		if (num < 0) {
			throw new IllegalArgumentException("num < 0");
		}

		if (radix < 1) {
			throw new IllegalArgumentException("radix < 1");
		}

		final int divisor = (int) Math.pow(10, radix - 1);

		return (num / divisor) % NUM_BUCKETS;
	}

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));

		final int maxLen = (int) Math.log10(max - min) + 1;

		final List[] buckets = new ArrayList[NUM_BUCKETS];

		for (int l = 1; l <= maxLen; l++) {
			reset(buckets);

			for (final int i : a) {
				final int significant = getSignificant(i - min, l);
				buckets[significant].add(i);
			}

			int offset = 0;
			for (final List<Integer> bucket : buckets) {
				for (final int i : bucket) {
					a[offset++] = i;
				}
			}
		}
	}

	private static void reset(final List[] buckets)
	{
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				buckets[i].clear();
			} else {
				buckets[i] = new ArrayList<Integer>();
			}
		}
	}
}