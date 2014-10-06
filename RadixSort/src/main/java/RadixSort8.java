package main.java;

import java.util.ArrayList;
import java.util.List;

public class RadixSort8 {

	public static int getSignificant(final int num, int position) {
		if (position < 1) {
			throw new IllegalArgumentException();
		}
		
		final int divisor = (int) Math.pow(10, position - 1);
		return (num / divisor) % 10;
	}

	private final static int N_BUCKETS = 10;
	
	public static void sort(final Integer[] a) {
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
		
		final int max_len = (int)Math.log10(max - min) + 1;
		
		final List<Integer>[] buckets = new ArrayList[N_BUCKETS];
		
		for (int radix = 1; radix <= max_len; radix++) {
			init(buckets);
			
			for (final int i : a) {
				final int significat = getSignificant(i - min, radix);
				buckets[significat].add(i);
			}
			
			int counter = 0;
			for (int b = 0; b < buckets.length; b++) {
				for (final int i : buckets[b]) {
					a[counter++] = i;
				}
			}
		}
	}
	
	private static void init(final List<?>[] buckets) {
		for (int b = 0; b < buckets.length; b++) {
			if (buckets[b] == null) {
				buckets[b] = new ArrayList<>();
			} else {
				buckets[b].clear();
			}
		}
	}
}
