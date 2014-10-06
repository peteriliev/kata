package main.java;

import java.util.ArrayList;
import java.util.List;

public class RadixSort9 {

	public static int getSignificant(final int num, final int raidix) {
		if (num < 0) {
			throw new IllegalArgumentException();
		}

		if (raidix < 0) {
			throw new IllegalArgumentException();
		}

		final int divisor = (int) Math.pow(10, raidix - 1);

		return (num / divisor) % 10;
	}

	final private static int N_BUCKETS = 10;

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

		final int maxLen = (int) Math.log10(max - min) + 1;

		final List[] buckets = new List[N_BUCKETS];

		for (int radix = 1; radix <= maxLen; radix++) {
			initBuckets(buckets);
			for (final int i : a) {
				final int significant = getSignificant(i - min, radix);
				buckets[significant].add(i);
			}

			int counter = 0;
			for (final List l : buckets) {
				for (final Object obj : l) {
					a[counter++] = (Integer) obj;
				}
			}
		}
	}

	private final static void initBuckets(final List[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == null) {
				buckets[i] = new ArrayList<Integer>();
			} else {
				buckets[i].clear();
			}

		}
	}
}
