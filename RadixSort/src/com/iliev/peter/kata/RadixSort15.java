package com.iliev.peter.kata;

import java.util.ArrayList;
import java.util.List;

public class RadixSort15 {

	public static int getSignificant(final int num, final int position) {
		if (position < 1) {
			throw new IllegalArgumentException();
		}

		if (num < 0) {
			throw new IllegalArgumentException();
		}

		final int divident = (int) Math.pow(10, position - 1);
		return (num / divident) % 10;
	}

	public static void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}

		final List[] buckets = new ArrayList[10];

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (final int i : a) {
			if (min > i) {
				min = i;
			}
			if (max < i) {
				max = i;
			}
		}
		final int normalized = max - min;
		final int maxLen = (normalized == 0 ? 1 : ((int) Math.log10(normalized) + 1));

		for (int pos = 1; pos <= maxLen; pos++) {
			initList(buckets);

			for (final int i : a) {
				final int num = getSignificant(i - min, pos);
				buckets[num].add(i);
			}

			int offset = 0;
			for (final List bucket : buckets) {
				for (final Object obj : bucket) {
					a[offset++] = (Integer) obj;
				}
			}
		}

	}

	private static void initList(final List[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				buckets[i].clear();
			} else {
				buckets[i] = new ArrayList<>();
			}
		}
	}
}
