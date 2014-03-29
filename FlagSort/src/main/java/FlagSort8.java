package main.java;

public class FlagSort8 {

	final private static int BUCKETS = 10;

	public static int getDigit(final int num, final int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException();
		}

		return (num / divisor) % BUCKETS;
	}

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

		return (int) Math.log10(max) + 1;
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
		final int divisor = (int) Math.pow(BUCKETS, maxLen - 1);
		sortInternal(a, 0, a.length, divisor);

		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}
	}

	private static void sortInternal(final Integer[] a, final int s,
			final int eX, final int divisor) {
		int counts[] = new int[BUCKETS];

		for (int c = s; c < eX; c++) {
			final int radix = getDigit(a[c], divisor);
			counts[radix]++;
		}

		int offsets[] = new int[BUCKETS];
		offsets[0] = s;
		for (int o = 1; o < BUCKETS; o++) {
			offsets[o] = offsets[o - 1] + counts[o - 1];
		}

		for (int b = 0; b < BUCKETS; b++) {
			while (counts[b] > 0) {
				final int offset = offsets[b];
				int from = offset;
				int num = a[from];

				do {

					final int radix = getDigit(num, divisor);

					final int to = offsets[radix];

					offsets[radix]++;
					counts[radix]--;

					final int tmp = a[to];
					a[to] = num;

					num = tmp;
					from = to;

				} while (from != offset);
			}
		}

		if (divisor > 1) {
			for (int b = 0; b < BUCKETS; b++) {
				int start = (b == 0 ? s : offsets[b - 1]);
				int endX = offsets[b];
				if (endX - start > 1) {
					sortInternal(a, start, endX, divisor / 10);
				}
			}
		}
	}

}
