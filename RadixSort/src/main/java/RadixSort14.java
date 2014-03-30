package com.iliev.peter.kata;

import java.util.ArrayList;
import java.util.List;

public class RadixSort14 {

	public static int getSignificant(final int num, final int position) {
		if (position < 1) {
			throw new IllegalArgumentException();
		}

		final int divisor = (int) Math.pow(10, position - 1);
		return (num / divisor) % 10;
	}

	public static void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (final int i : a) {
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
		}

		final int normalize = max - min;
		final int maxLen = (int) (Math.log10(normalize) + 1);

		List[] buckets = new ArrayList[10];

		for (int radix = 1; radix <= maxLen; radix++) {
			init(buckets);
			for (final int i : a) {
				final int digit = getSignificant(i - min, radix);
				buckets[digit].add(i);
			}

			int offset = 0;
			for (final List bucket : buckets) {
				for (final Object obj : bucket) {
					a[offset++] = (Integer) obj;
				}

			}
		}

	}

	private final static void init(final List[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null)
				a[i] = new ArrayList<>();
			else
				a[i].clear();
		}
	}
}
