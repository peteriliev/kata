package main.java;

import java.util.Arrays;
import java.util.Collections;

public class FlagSort31 {

	private static final int NUM_BUCKETS = 10;

	public static int getDigit(final int number, final int divisor) {
		if (number < 0) {
			throw new IllegalArgumentException("number < 0");
		}
		if (divisor < 1) {
			throw new IllegalArgumentException("divisor < 1");
		}

		return (number / divisor) % NUM_BUCKETS;
	}

	public static int getMaxLength(final Integer[] a) {
		if (null == a) {
			throw new IllegalArgumentException("a is null");
		}

		if (0 == a.length) {
			return 0;
		}

		final int max = Collections.max(Arrays.asList(a));
		final int maxLen = (int) Math.log10(max) + 1;

		return maxLen;
	}

	public static void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
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

	private static void sortInternal(final Integer[] a, final int start, final int end, final int divisor) {
		final int counts[] = new int[NUM_BUCKETS];

		for (int i = start; i < end; i++) {
			final int digit = getDigit(a[i], divisor);
			counts[digit]++;
		}

		final int offsets[] = new int[NUM_BUCKETS];
		offsets[0] = start;
		for (int i = 1; i < NUM_BUCKETS; i++) {
			offsets[i] = offsets[i - 1] + counts[i - 1];
		}

		for (int b = 0; b < NUM_BUCKETS; b++) {
			while (counts[b] > 0) {
				final int offset = offsets[b];
				int from = offset;
				int num = a[offset];

				do {
					final int digit = getDigit(num, divisor);
					final int to = offsets[digit];
					final int tmp = a[to];

					counts[digit]--;
					offsets[digit]++;

					a[to] = num;
					num = tmp;
					from = to;
				} while (from != offset);

			}
		}

		if (divisor > 1) {
			for (int i = 0; i < NUM_BUCKETS; i++) {
				final int s = i == 0 ? start : offsets[i - 1];
				final int e = offsets[i];

				if (e - s > 1) {
					sortInternal(a, s, e, divisor / NUM_BUCKETS);
				}
			}
		}
	}
}
