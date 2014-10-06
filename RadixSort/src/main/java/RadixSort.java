package main.java;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

	public static void sort(final Integer[] a) {

		if (a == null || a.length <= 1) {
			return;
		}

		final List[] bins = new ArrayList[10];

		int min = a[0];
		for (final Integer iii : a) {
			min = Math.min(min, iii);
		}

		for (int radix = 1; radix < 100; radix++) {
			initBins(bins);

			for (int i : a) {
				final int ls = getLeastSignificante(i - min, radix);
				bins[ls].add(i - min);
			}

			int index = 0;
			for (final List<?> bin : bins) {
				for (Object ii : bin) {
					final Integer integer = (Integer) ii;
					a[index++] = integer + min;
				}
			}
		}
	}

	private static void initBins(final List<?>[] bins) {
		for (int i = 0; i < bins.length; i++) {
			if (bins[i] == null) {
				bins[i] = new ArrayList<Integer>();
			} else {
				bins[i].clear();
			}
		}
	}

	public static int getLeastSignificante(final int target, final int radix) {
		final int mod = (int) Math.pow(10, radix);
		final int n = (int) Math.pow(10, radix - 1);

		return (target % mod) / n;
	}

}
