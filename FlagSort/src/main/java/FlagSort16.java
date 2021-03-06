package main.java;

public class FlagSort16 {

	public static int getDigit(final int num, final int divisor) {
		if (divisor <= 0) {
			throw new IllegalArgumentException();
		}

		return (num / divisor) % 10;
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
			if (max < i) {
				max = i;
			}
		}

		return (int) Math.log10(max) + 1;
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

		for (int i = 0; i < 10; i++) {
			while (counts[i] > 0) {
				final int offset = offsets[i];
				int from = offset;
				int num = a[from];

				do {
					final int digit = getDigit(num, divisor);
					final int to = offsets[digit];
					final int tmp = a[to];

					offsets[digit]++;
					counts[digit]--;

					a[to] = num;
					from = to;
					num = tmp;

				} while (from != offset);
			}
		}

		if (divisor > 1) {
			for (int i = 0; i < 10; i++) {
				final int s = (i == 0 ? start : offsets[i - 1]);
				final int eX = offsets[i];
				if (eX - s > 1) {
					sortInternal(a, s, eX, divisor / 10);
				}
			}
		}
	}
}
