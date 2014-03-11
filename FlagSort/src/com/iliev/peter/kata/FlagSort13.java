package com.iliev.peter.kata;

public class FlagSort13 {
	private final static int N_BUCKETS = 10;

	public static final void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}

		int min = Integer.MAX_VALUE;
		for (final int i : a) {
			if (i < min) {
				min = i;
			}
		}

		for (int i = 0; i < a.length; i++) {
			a[i] -= min;
		}

		final int max = getMaxLength(a);
		final int divisor = (int) Math.pow(N_BUCKETS, max - 1);
		sortInternal(a, 0, a.length, divisor);

		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}
	}

	public static final void sortInternal(final Integer[] a, final int start,
			final int endX, final int divisor) {
		final int counts[] = new int[N_BUCKETS];

		for (int i = start; i < endX; i++) {
			final int num = getDigit(a[i], divisor);
			counts[num]++;
		}

		final int offsets[] = new int[N_BUCKETS];
		offsets[0] = start;
		for (int i = 1; i < N_BUCKETS; i++) {
			offsets[i] = offsets[i - 1] + counts[i - 1];
		}

		for (int b = 0; b < N_BUCKETS; b++) {
			while (counts[b] > 0) {
				final int offset = offsets[b];
				int from = offset;
				int num = a[from];

				do {
					int digit = getDigit(num, divisor);
					final int to = offsets[digit];

					offsets[digit]++;
					counts[digit]--;

					final int tmp = a[to];

					a[to] = num;
					num = tmp;
					from = to;

				} while (offset != from);
			}
		}

		if (divisor > 1) {
			for (int i = 0; i < N_BUCKETS; i++) {
				final int s = (i == 0 ? start : offsets[i - 1]);
				final int eX = offsets[i];
				if (eX - s > 1) {
					sortInternal(a, s, eX, divisor / 10);
				}
			}
		}
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
			if (i > max) {
				max = i;
			}
		}

		return (int) Math.log10(max) + 1;
	}

	public static int getDigit(final int num, final int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException();
		}

		return (num / divisor) % N_BUCKETS;
	}
}
