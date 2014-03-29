package com.iliev.peter.kata;

public class FlagSort15 {

	public static int getMaxLength(final Integer[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		if (0 == a.length) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		for (final int i : a) {
			if (max < i) {
				max = i;
			}
		}
		return (int) (Math.log10(max) + 1);
	}

	public static void sort(final Integer[] a) {
		if (a.length < 2) {
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
		final int divisor = (int) Math.pow(10, maxLen - 1);
		sortInternal(a, 0, a.length, divisor);

		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}
	}

	private static void sortInternal(final Integer[] a, final int start, final int endX, final int divisor) {
		final int[] counts = new int[10];
		for (int i = start; i < endX; i++) {
			final int digit = getDigit(a[i], divisor);
			counts[digit]++;
		}

		final int[] offsets = new int[10];
		offsets[0] = start;
		for (int i = 1; i < 10; i++) {
			offsets[i] = offsets[i - 1] + counts[i - 1];
		}

		for (int b = 0; b < 10; b++) {
			while (counts[b] > 0) {
				final int offset = offsets[b];
				int from = offset;
				int num = a[from];

				do {
					final int digit = getDigit(num, divisor);
					final int to = offsets[digit];

					offsets[digit]++;
					counts[digit]--;
					final int tmp = a[to];
					a[to] = num;

					num = tmp;
					from = to;

				} while (from != offset);
			}
		}

		if (divisor > 1) {
			for (int b = 0; b < 10; b++) {
				final int s = (b == 0 ? start : offsets[b - 1]);
				final int eX = offsets[b];
				if (eX - s > 1) {
					sortInternal(a, s, eX, divisor / 10);
				}
			}
		}
	}

	public static int getDigit(final int num, final int divisor) {
		if (divisor < 1) {
			throw new IllegalArgumentException(((Integer) divisor).toString());
		}

		return (num / divisor) % 10;
	}

}
