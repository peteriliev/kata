package main.java;

public class FlagSort4 {
	public static void sort(final Integer[] a) {
		if (a.length <= 1) {
			return;
		}

		final int min = getMin(a);

		for (int i = 0; i < a.length; i++) {
			a[i] -= min;
		}

		final int maxLength = getMaxLength(a);
		final int divisor = (int) Math.pow(10, maxLength - 1);

		sortInternal(a, 0, a.length, divisor);

		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}

	}

	final static int N_COUNT = 10;

	public static void sortInternal(final Integer[] a, final int start,
			final int endX, final int divisor) {

		if (start >= endX) {
			return;
		}

		final int counts[] = new int[N_COUNT];
		final int offsets[] = new int[N_COUNT];

		for (int i = start; i < endX; i++) {
			final int digit = getDigit(a[i], divisor);
			counts[digit]++;
		}

		offsets[0] = start;
		for (int i = 1; i < N_COUNT; i++) {
			offsets[i] = offsets[i - 1] + counts[i - 1];
		}

		for (int b = 0; b < N_COUNT; b++) {
			while (counts[b] > 0) {
				final int offset = offsets[b];
				int from = offset;
				int num = a[from];
				a[from] = -1;

				do {
					final int digit = getDigit(num, divisor);
					int to = offsets[digit];

					final int tmp = a[to];
					a[to] = num;

					offsets[digit]++;
					counts[digit]--;

					num = tmp;
					from = to;

				} while (from != offset);
			}
		}

		if (divisor > 1) {
			for (int b = 0; b < N_COUNT; b++) {
				int s = (b == 0 ? start : offsets[b - 1]);
				int e = offsets[b];
				if (e - s > 1) {
					sortInternal(a, s, e, divisor / 10);
				}
			}
		}
	}

	public static int getMin(final Integer[] a) {
		int min = Integer.MAX_VALUE;
		for (final int i : a) {
			if (min > i) {
				min = i;
			}
		}

		return min;
	}

	public static int getDigit(final int i, final int divisor) {
		return (i / divisor) % 10;
	}

	public static int getMaxLength(final Integer[] integers) {
		if (integers == null) {
			throw new IllegalArgumentException();
		}

		if (integers.length == 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE;

		for (final Integer i : integers) {
			if (max < i) {
				max = i;
			}
		}

		return (int) Math.log10(max) + 1;
	}
}
