package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RadixSort23 {

	public static int getSignificant(final int num, final int position)
	{
		if (num < 0) {
			throw new IllegalArgumentException("num < 0");
		}
		if (num == 0) {
			return 0;
		}
		if (position < 1) {
			throw new IllegalArgumentException("pos < 1");
		}

		final int divisor = (int) Math.pow(10, position - 1);

		return (num / divisor) % 10;
	}

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		final int maxLen = (int) Math.log10(max - min) + 1;

		List[] buckets = new ArrayList[10];

		for (int radix = 1; radix <= maxLen; radix++) {
			initBuckets(buckets);
			for (final int i : a) {
				final int significant = getSignificant(i - min, radix);
				buckets[significant].add(i);
			}

			int offset = 0;
			for (final List<Integer> bucket : buckets) {
				for (final Integer i : bucket) {
					a[offset++] = i;
				}
			}
		}
	}

	private static final void initBuckets(final List[] buckets)
	{
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == null) {
				buckets[i] = new ArrayList();
			} else {
				buckets[i].clear();
			}
		}
	}
}