package com.iliev.peter.kata;

public class FlagSort {

	private static final int N_BUCKETS = 10;

	public static void sort(final Integer[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		if (a.length <= 1) {
			return;
		}

		int min = Integer.MAX_VALUE;
		for (final Integer i : a) {
			if (i < min) {
				min = i;
			}
		}

		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] - min;
		}

		final int maxLength = getMaxLength(a);
		final int divisor = (int) Math.pow(10, maxLength - 1);

		sortInternal(a, 0, a.length, divisor);

		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] + min;
		}
	}

	private static void sortInternal(final Integer[] a, final int start,
			final int length, final int divisor) {

		final int[] counts = new int[N_BUCKETS];
		final int[] offsets = new int[N_BUCKETS];

		for (int i = start; i < length; i++) {
			counts[getDigit(a[i], divisor)]++;
		}

		offsets[0] = start;
		for (int b = 1; b < N_BUCKETS; b++) {
			offsets[b] = offsets[b - 1] + counts[b - 1];
		}

		for (int b = 0; b < N_BUCKETS; b++) {
			while (counts[b] > 0) {
				int orignin = offsets[b];
				int from = orignin;

				int num = a[from];
				a[from] = -1;

				do {
					final int digit = getDigit(num, divisor);
					int to = offsets[digit];

					counts[digit]--;
					offsets[digit]++;

					final int tmp = a[to];
					a[to] = num;

					from = to;
					num = tmp;

				} while (from != orignin);
			}
		}

		if (divisor > 1) {
			for (int i = 0; i < N_BUCKETS; i++) {
				int s = i > 0 ? offsets[i - 1] : start;
				int e = offsets[i];
				if (e - s > 1) {
					sortInternal(a, s, e, divisor / 10);
				}
			}
		}
	}

	public static int getDigit(final int num, final int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException();
		}

		return (num / divisor) % 10;
	}

	public static int getMaxLength(final Integer[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		if (a.length == 0) {
			return 0;
		}

		int result = Integer.MIN_VALUE;

		for (final Integer i : a) {
			int tmp = (int) (Math.log10(i) + 1);
			if (tmp > result) {
				result = tmp;
			}
		}

		return result;
	}
}
