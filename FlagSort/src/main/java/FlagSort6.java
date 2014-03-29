package main.java;

public class FlagSort6 {

	public static int getDigit(final int num, final int divisor) {
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
		for (final Integer i : a) {
			if (i > max) {
				max = i;
			}
		}

		return (int) Math.log10(max) + 1;
	}

	public static void sort(final Integer[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

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

		final int maxLenght = getMaxLength(a);
		final int divisor = (int) Math.pow(N_BUCKETS, maxLenght - 1);

		sortInternal(a, 0, a.length, divisor);

		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}
	}

	private static final int N_BUCKETS = 10;

	public static void sortInternal(final Integer[] a, final int start,
			final int endX, final int divisor) {

		int lenght = endX - start;
		if (lenght <= 1) {
			return;
		}

		final int counts[] = new int[N_BUCKETS];
		final int offsets[] = new int[N_BUCKETS];

		for (int i = start; i < endX; i++) {
			final int radix = getDigit(a[i], divisor);
			counts[radix]++;
		}

		offsets[0] = start;
		for (int i = 1; i < N_BUCKETS; i++) {
			offsets[i] = offsets[i - 1] + counts[i - 1];
		}

		for (int b = 0; b < N_BUCKETS; b++) {
			while (counts[b] > 0) {
				int offset = offsets[b];
				int from = offset;
				int num = a[from];

				do {
					int digit = getDigit(num, divisor);
					int to = offsets[digit];

					offsets[digit]++;
					counts[digit]--;

					int tmp = a[to];
					a[to] = num;

					num = tmp;
					from = to;

				} while (from != offset);
			}
		}

		if (divisor > 1) {
			for (int b = 0; b < N_BUCKETS; b++) {
				int s0 = (b == 0 ? start : offsets[b - 1]);
				int e0 = offsets[b];
				sortInternal(a, s0, e0, divisor / 10);
			}
		}
	}
}
