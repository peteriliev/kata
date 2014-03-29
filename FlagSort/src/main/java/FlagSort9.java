package main.java;

import java.util.Arrays;

public class FlagSort9 {

	public static int getDigit(final int num, final int divisor)
			throws Exception {
		if (0 == divisor) {
			throw new Exception(new IllegalArgumentException("0"));
		}

		if (0 > num) {
			throw new Exception(new IllegalArgumentException("negative num"));
		}

		return (num / divisor) % N_BUCKETS;
	}

	public static int getMaxLength(final Integer[] a) throws Exception {
		if (null == a) {
			throw new Exception(new IllegalArgumentException("NULL"));
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
		return (int) (Math.log10(max) + 1);
	}

	public static void sort(final Integer[] a) {
		int min = Integer.MAX_VALUE;
		/*
		 * for (final int i : a) { if (i < min) { min = i; } }
		 */
		for (int i = 0; i < a.length; i++) {
			a[i] -= min;
		}

		int maxLen;
		try {
			maxLen = getMaxLength(a);
		} catch (Exception e) {
			throw new RuntimeException(String.format("Cannot sort %s",
					Arrays.toString(a)), e);
		}
		final int divisor = (int) Math.pow(N_BUCKETS, maxLen - 1);
		sortInternal(a, 0, a.length, divisor);

		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}
	}

	private static final int N_BUCKETS = 10;

	private static void sortInternal(final Integer[] a, final int s,
			final int eX, final int divisor) {
		final int counts[] = new int[N_BUCKETS];
		for (int i = s; i < eX; i++) {
			int digit;
			try {
				digit = getDigit(a[i], divisor);
			} catch (Exception e) {
				throw new RuntimeException(String.format("Cannot sort %s, start = %s,  endX = %s",
						Arrays.toString(a), s, eX), e);
			}
			counts[digit]++;
		}

		final int offsets[] = new int[N_BUCKETS];
		offsets[0] = s;
		for (int o = 1; o < N_BUCKETS; o++) {
			offsets[o] = offsets[o - 1] + counts[o - 1];
		}

		for (int b = 0; b < N_BUCKETS; b++) {
			while (counts[b] > 0) {

				final int offset = offsets[b];
				int from = offset;
				int num = a[from];

				do {
					int dig;
					try {
						dig = getDigit(num, divisor);
					} catch (Exception e) {
						throw new RuntimeException(String.format("Cannot sort %s, start = %s,  endX = %s",
								Arrays.toString(a), s, eX), e);
					}
					int to = offsets[dig];

					offsets[dig]++;
					counts[dig]--;

					final int tmp = a[to];
					a[to] = num;

					num = tmp;
					from = to;

				} while (from != offset);
			}
		}

		if (divisor > 1) {
			for (int b = 0; b < N_BUCKETS; b++) {
				int start = (b == 0 ? s : offsets[b - 1]);
				int endX = offsets[b];
				if (endX - start > 1) {
					sortInternal(a, start, endX, divisor / 10);
				}
			}
		}
	}
}
