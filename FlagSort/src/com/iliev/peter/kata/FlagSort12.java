package com.iliev.peter.kata;

public class FlagSort12 {

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
		
		return (int) (Math.log10(max) + 1);
	}

	public static int getDigit(final int num, final int divisor) {
		if (0 == divisor) {
			throw new IllegalArgumentException();
		}
		
		if (num < 0 || divisor < 0) {
			throw new IllegalArgumentException("less than zero");
		}
		
		return (num / divisor) % N_BUCKETS;
	}
	
	private static final int N_BUCKETS = 10;

	public static void sort(final Integer[] a) {
		int min = Integer.MAX_VALUE;
		for (final int i : a) {
			if (i < min) {
				min = i;
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			a[i] -= min;
		}
		
		final int max_len = getMaxLength(a);
		final int divisor = (int) Math.pow(N_BUCKETS, max_len - 1);
		sortInternal(a, 0, a.length, divisor);
		
		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}
	}
	
	public static void sortInternal(final Integer[] a, final int start, final int endX, final int divisor) {
		final int[] counts = new int[N_BUCKETS];
		for (int i = start; i < endX; i++) {
			final int digit = getDigit(a[i], divisor);
			counts[digit]++;
		}
		
		
		final int[] offsets = new int[N_BUCKETS];
		offsets[0] = start;
		for (int o = 1; o < N_BUCKETS; o++) {
			offsets[o] = offsets[o - 1] + counts[o - 1];
		}
		
		for (int b = 0; b < N_BUCKETS; b++) {
			while (counts[b] > 0) {
				final int offset = offsets[b];
				int from = offset;
				int num = a[offset];
				
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
			for (int i = 0; i < N_BUCKETS; i++) {
				final int s = (i == 0 ? start : offsets[i - 1]);
				final int eX = offsets[i];
				if (eX - s > 1) {
					sortInternal(a, s, eX, divisor/ 10);
				}
			}
		}
	}
	
}
