package main.java;

public class FlagSort2 {

	public static int getMaxLength(final Integer[] integers) {
		if (integers == null) {
			throw new IllegalArgumentException();
		}

		if (integers.length == 0) {
			return 0;
		}

		int result = Integer.MIN_VALUE;

		for (final int i : integers) {
			final int len = (int) Math.log10(i) + 1;
			if (len > result) {
				result = len;
			}
		}

		return result;

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
		
		final int maxLength = getMaxLength(a);
		final int divisor = (int)Math.pow(10, maxLength - 1);
		
		sortInternal(a, 0, a.length, divisor);

		for (int i = 0; i < a.length; i++) {
			a[i] += min;
		}

	}
	
	private static final int N_COUNT = 10;

	public static void sortInternal(final Integer[] a, final int s,
			final int eX, final int divisor) {
		
		final int counts[] = new int[N_COUNT];
		final int offsets[] = new int[N_COUNT];

		for (int i = s; i < eX; i++) {
			final int j = a[i];
			counts[getDigit(j, divisor)]++;
		}
		
		offsets[0] = s;
		for (int o = 1; o < N_COUNT; o++) {
			offsets[o] = offsets[o-1] + counts[o-1]; 
		}
		
		for (int bucket = 0; bucket < N_COUNT; bucket++) {
			while (counts[bucket] > 0) {
				final int origin = offsets[bucket];
				int from = origin;
				int num = a[from];
				a[from] = -1;
				
				do {
					final int digit = getDigit(num, divisor);
					final int to = offsets[digit];
					
					offsets[digit]++;
					counts[digit]--;
					
					final int tmp = a[to];
					a[to] = num;
					
					num = tmp;
					from = to;
				} while (from != origin);
			}
		}
		
		if (divisor > 1) {
			for (int bucket = 0; bucket < N_COUNT; bucket++) {
				final int start = bucket == 0 ? s : offsets[bucket - 1];
				final int end = offsets[bucket];
				if (end - start > 1) {
					sortInternal(a, start, end, divisor / 10);
				}
			}
		}
	}

	public static int getDigit(final int i, final int j) {
		return (i / j) % 10;
	}

}
