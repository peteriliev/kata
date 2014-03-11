package com.iliev.peter.kata;

import java.util.ArrayList;
import java.util.List;

public class RadixSort7 {

	public static void sort(final Integer[] a) {
		if (1 >= a.length) {
			return;
		}

		int min = Integer.MAX_VALUE;
		for (final int i : a) {
			if (min > i) {
				min = i;
			}
		}

		List<Integer>[] buckest = new ArrayList[10];
		for (int r = 1; r < 16; r++) {
			reset(buckest);
			
			for (final int i : a) {
				final int radix = getSignificant(i - min, r);
				buckest[radix].add(i);
			}
			
			int offset = 0;
			for (final List<Integer> buck : buckest) {
				for (final int i : buck) {
					a[offset++] = i;
				}
			}
		}
	}

	private static void reset(final List<Integer>[] buckets) {
		for (int b = 0; b < buckets.length; b++) {
			if (buckets[b] == null) {
				buckets[b] = new ArrayList<>();
			} else {
				buckets[b].clear();
			}
		}
	}

	public static int getSignificant(final int num, int position) {
		final int divsort = (int) Math.pow(10, position - 1);
		return (num / divsort) % 10;
	}
}
