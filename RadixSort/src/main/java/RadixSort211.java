package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RadixSort211 {

	private static final int NUM_BUCKETS = 10;

	public static int getSignificant(final int num, final int radix)
	{
		if (num < 0) {
			throw new IllegalArgumentException();
		}

		if (radix < 1) {
			throw new IllegalArgumentException();
		}

		final int divisor = (int) Math.pow(NUM_BUCKETS, radix - 1);
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

		for (int radix = 1; radix <= maxLen; radix++) {
			reset(buckets);
			for (final Integer i : a) {
				final int sig = getSignificant(i - min, radix);
				buckets[sig].add(i);
			}
			int offset = 0;
			for (final List bucket : buckets) {
				for (final Object obj : bucket) {
					a[offset++] = (Integer) obj;
				}
			}
		}
	}

	private static void reset(final List[] buckets)
	{
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == null) {
				buckets[i] = new ArrayList<>();
			} else {
				buckets[i].clear();
			}
		}
	}
}
