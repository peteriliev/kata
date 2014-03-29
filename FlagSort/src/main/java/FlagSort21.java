package main.java;

import java.util.Arrays;
import java.util.Collections;

public class FlagSort21 {

	private static final int NUM_BUCKETS = 10;

	public static int getMaxLength(final Integer[] a)
	{
		if (a == null) {
			throw new IllegalArgumentException();
		}

		if (a.length == 0) {
			return 0;
		}

		final int max = Collections.max(Arrays.asList(a));
		if (max == 0) {
			return 0;
		}

		return (int) Math.log10(max) + 1;
	}

	public static int getDigit(final int num, final int divisor)
	{
		if (num < 0) {
			throw new IllegalArgumentException();
		}

		if (divisor < 1) {
			throw new IllegalArgumentException();
		}

		return (num / divisor) % NUM_BUCKETS;
	}

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));

		for (int i = 0; i < a.length; i++) {
			a[i] -= min;
		}

		final int maxLen = getMaxLength(a);
		final int d = (int) Math.pow(10, maxLen - 1);
		sortInternal(a, 0, a.length, d);

		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}
	}

	public static void sortInternal(final Integer[] a, final int start, final int endX, final int divisor)
	{
		final int[] counts = new int[NUM_BUCKETS];
		final int[] offsets = new int[NUM_BUCKETS];

		for (int i = start; i < endX; i++) {
			final int num = getDigit(a[i], divisor);
			counts[num]++;
		}

		offsets[0] = start;
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
					num = tmp;
					from = to;

				} while (from != offset);
			}
		}

		if (divisor > 1) {
			for (int b = 0; b < NUM_BUCKETS; b++) {
				final int s = b == 0 ? start : offsets[b - 1];
				final int e = offsets[b];
				if (e - s > 1) {
					sortInternal(a, s, e, divisor / 10);
				}
			}
		}
	}
}
