package com.iliev.peter.kata;

public class FlagSort11 {

	private final static int N_BUCKETS = 10;

	public static int getDigit(final int num, final int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("Divisor 0");
		}

		return (num / divisor) % N_BUCKETS;
	}

	public static int getMaxLength(final Integer[] a) {
		if (null == a) {
			throw new IllegalArgumentException();
		}

		if (0 == a.length) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		for (final int i : a) {
			if (max < i)
				max = i;
		}
		return (int) (Math.log10(max) + 1);
	}

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

		for (int i = 0; i < a.length; i++) {
			a[i] -= min;
		}

		final int maxLen = getMaxLength(a);
		final int divisor = (int) Math.pow(N_BUCKETS, maxLen - 1);
		sortInternal(a, 0, a.length, divisor);

		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}
	}

	public static void sortInternal(final Integer[] a, final int s,
			final int eX, final int divisor) {
		final int[] counts = new int[N_BUCKETS];
		for (int i = s; i < eX; i++) {
			final int digit = getDigit(a[i], divisor);
			counts[digit]++;
		}

		final int[] offsets = new int[N_BUCKETS];
		offsets[0] = s;
		for (int b = 1; b < N_BUCKETS; b++) {
			offsets[b] = offsets[b - 1] + counts[b - 1];
		}

		for (int b = 0; b < N_BUCKETS; b++) {
			while (counts[b] > 0) {
				final int offset = offsets[b];
				int from = offset;
				int num = a[from];
				do {
					final int dig = getDigit(num, divisor);
					final int to = offsets[dig];

					offsets[dig]++;
					counts[dig]--;

					final int tmp = a[to];
					a[to] = num;

					num = tmp;
					from = to;

				} while (offset != from);
			}
		}

		if (divisor > 1) {
			for (int b = 0; b < N_BUCKETS; b++) {
				final int start = (b == 0 ? s : offsets[b - 1]);
				final int endX = offsets[b];
				if (endX - start > 1) {
					sortInternal(a, start, endX, divisor / N_BUCKETS);
				}
			}
		}
	}

}
