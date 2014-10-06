package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RadixSort21 {

	public static int getSignificant(final int num, final int radix)
	{
		if (num < 0) {
			throw new IllegalArgumentException();
		}

		if (radix < 1) {
			throw new IllegalArgumentException();
		}

		final int divisor = (int) Math.pow(10, radix - 1);

		return (num / divisor) % 10;
	}

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int max = Collections.max(Arrays.asList(a));
		final int min = Collections.min(Arrays.asList(a));

		final int maxLen = (int) Math.log10(max - min) + 1;

		final List[] buckets = new ArrayList[10];
		for (int radix = 1; radix <= maxLen; radix++) {
			reset(buckets);
			for (final Integer i : a) {
				final int b = getSignificant(i - min, radix);
				buckets[b].add(i);
			}

			int offset = 0;
			for (final List bucket : buckets) {
				if (null == bucket) {
					continue;
				}
				for (final Object i : bucket) {
					a[offset++] = (Integer) i;
				}
			}
		}
	}

	private static void reset(final List[] a)
	{
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null) {
				a[i] = new ArrayList<>();
			} else {
				a[i].clear();
			}
		}
	}
}
