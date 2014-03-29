package com.iliev.peter.kata;

public class FlagSort3 {

	public static int getDigit(int i, int j) {
		return (i / j) % 10;
	}

	public static int getMaxLength(Integer[] integers) {
		if (integers == null) {
			throw new IllegalArgumentException();
		}
		
		if (integers == null || integers.length == 0) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		for (final int i : integers) {
			if (i > max) {
				max = i;
			}
		}
		
		return (int)Math.log10(max) + 1;
	}

	public static void sort(final Integer[] a) {
		if (a.length <= 1) {
			return;
		}
		int min = Integer.MAX_VALUE;
		for (final Integer i : a) {
			if (min > i) {
				min = i;
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			a[i] -= min;
		}
		
		final int divisor = (int) Math.pow(10, getMaxLength(a) -1);
		sortInternal(a, 0, a.length, divisor);

		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}
	}
	
	private static final int N_SIZE = 10;

	public static void sortInternal(final Integer[] a, final int s, final int eX, final int divisor) {
		final int[] counts = new int[N_SIZE];
		final int[] offsets = new int[N_SIZE];
		
		//for (final int i : a) {
		for (int j = s; j < eX; j++) {
			final int digit = getDigit(a[j], divisor);
			counts[digit]++;
		}
		
		offsets[0] = s;
		for (int o = 1; o < N_SIZE; o++) {
			offsets[o] = offsets[o-1] + counts[o-1];
			
		}
		
		for (int b = 0; b < N_SIZE; b++) {
			while (counts[b] > 0) {
				final int offset = offsets[b];
				int from = offset;
				int num = a[from];
				a[from] = -1;
				
				do {
					final int digit = getDigit(num, divisor);
					final int to = offsets[digit];
					
					counts[digit]--;
					offsets[digit]++;
					
					final int tmp = a[to];
					a[to] = num;
					
					num = tmp;
					from = to;
				} while (from != offset);
				
			}
		}
		
		if (divisor > 1) {
			for (int b = 0; b < N_SIZE; b++) {
				int ss = (b == 0 ? s : offsets[b - 1]);
				int ee = offsets[b];
				if (ee - ss > 1) {
					sortInternal(a, ss, ee, divisor / 10);
				}
			}
		}
	}
}
