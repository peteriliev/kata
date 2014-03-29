package main.java;

public class FlagSort7 {

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

		int max = Integer.MIN_VALUE;
		for (final int i : a) {
			if (max < i) {
				max = i;
			}
		}

		return (int) (Math.log10(max) + 1);
	}

	public static void sort(final Integer[] a) {
		if (a.length <= 1) {
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

	private final static int N_BUCKETS = 10;

	private static void sortInternal(final Integer[] a, final int start,
			final int endX, final int divisor) {
		final int[] counts = new int[N_BUCKETS];

		for (int i = start; i < endX; i++) {
			final int digit = getDigit(a[i], divisor);
			counts[digit]++;
		}

		final int[] offsets = new int[N_BUCKETS];
		offsets[0] = start;
		for (int b = 1; b < N_BUCKETS; b++) {
			offsets[b] = offsets[b - 1] + counts[b - 1];
		}

		for (int b = 0; b < N_BUCKETS; b++) {
			while (counts[b] > 0) {
				int offset = offsets[b];
				int from = offset;
				int num = a[from];
				a[from] = -1;

				do {
					final int digit = getDigit(num, divisor);
					int to = offsets[digit];

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
			for (int b = 0; b < N_BUCKETS; b++) {
				final int s = (b == 0 ? start : offsets[b - 1]);
				final int e = (offsets[b]);
				if (e - s > 1) {
					sortInternal(a, s, e, divisor / 10);
				}
			}
		}
	}
}
