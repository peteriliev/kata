package main.java;

import java.util.ArrayList;
import java.util.List;

public class RadixSort5 {

	private final static int BASE = 10;

	public static int getSignificant(final int num, int radix) {
		final int divisor = (int) Math.pow(BASE, radix - 1);
		return (num / divisor) % BASE;
	}

	public static void sort(final Integer[] a) {
		if (a.length <= 1) {
			return;
		}
		
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
		
		final int max_length = (int) Math.log10(max - min) + 1;//
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new ArrayList[BASE];

		for (int radix = 1; radix <= max_length; radix++) {
			initBuckects(buckets);
			for (final int i : a) {
				final int destination = getSignificant(i - min, radix);
				buckets[destination].add(i - min);
			}
			int counter = 0;
			for (final List<Integer> bucket : buckets) {
				for (final Object obj : bucket) {
					a[counter++] = (Integer) obj + min;
				}
			}

		}
	}

	private static final void initBuckects(final List<Integer>[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == null) {
				buckets[i] = new ArrayList<Integer>();
			} else {
				buckets[i].clear();
			}
		}
	}
}
