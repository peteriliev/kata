package com.iliev.peter.kata;

import java.util.ArrayList;
import java.util.List;

public class RadixSort6 {

	public static int getSignificant(final int num, final int radix) {
		final int divisor = (int)Math.pow(10, radix - 1);
		return (num / divisor) % 10;
	}

	public static void sort(final Integer[] a) {
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
		
		final int normalizedMax = max - min;
		int maxLength = (int) (Math.log10(normalizedMax) + 1);
		
		for (int radix = 1; radix <= maxLength; radix++) {
			resetBuckets(buckets);
			for (final int i : a) {
				int target = getSignificant(i - min, radix);
				buckets[target].add(i );
			}
			
			int counter = 0;
			for (int b = 0; b < buckets.length; b++) {
				for (final Object obj : buckets[b]) {
					a[counter++] = (Integer)obj;
				}
			}
		}
	}
	
	private static final void resetBuckets(final List<?>[] buckets) {
		for (int b = 0; b < buckets.length; b++) {
			if (buckets[b] == null) {
				buckets[b] = new ArrayList();
			} else {
				buckets[b].clear();
			}
		}
	}
}
