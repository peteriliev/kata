package com.iliev.peter.kata;

import java.util.Arrays;
import java.util.Collections;

public class FlagSort27 {

	private static final int NUM_BUCKETS = 10;

	public static int getDigit(final int num, final int divisor)
	{
		if (num < 0) {
			throw new IllegalArgumentException("num < 0");
		}

		if (divisor < 1) {
			throw new IllegalArgumentException("divisor < 1");
		}

		return (num / divisor) % NUM_BUCKETS;
	}

	public static int getMaxLength(final Integer[] a)
	{
		if (null == a) {
			throw new IllegalArgumentException("a is NULL");
		}

		if (a.length == 0) {
			return 0;
		}

		final int max = Collections.max(Arrays.asList(a));

		return (int) Math.log10(max) + 1;
	}

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
		// final int max = Collections.max(Arrays.asList(a));

		for (int i = 0; i < a.length; i++) {
			a[i] -= min;
		}

		final int maxLen = getMaxLength(a);
		final int divisor = (int) Math.pow(NUM_BUCKETS, maxLen - 1);

		sortInternal(a, 0, a.length, divisor);

		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}
	}

	public static void sortInternal(final Integer[] a, final int s, final int e, final int divisor)
	{
		final int counts[] = new int[NUM_BUCKETS];
		for (int i = s; i < e; i++) {
			final int num = getDigit(a[i], divisor);
			counts[num]++;
		}

		final int offsets[] = new int[NUM_BUCKETS];
		offsets[0] = s;
		for (int i = 1; i < NUM_BUCKETS; i++) {
			offsets[i] = offsets[i - 1] + counts[i - 1];
		}

		for (int b = 0; b < NUM_BUCKETS; b++) {
			while (counts[b] > 0) {
				final int offset = offsets[b];
				int from = offset;
				int num = a[from];

				do {
					final int digit = getDigit(num, divisor);
					final int to = offsets[digit];
					final int tmp = a[to];

					offsets[digit]++;
					counts[digit]--;
					a[to] = num;

					from = to;
					num = tmp;

				} while (from != offset);
			}
		}

		if (divisor > 1) {
			for (int b = 0; b < NUM_BUCKETS; b++) {
				final int start = (b == 0 ? s : offsets[b - 1]);
				final int end = offsets[b];
				if (end - start > 1) {
					sortInternal(a, start, end, divisor / NUM_BUCKETS);
				}
			}
		}
	}
}