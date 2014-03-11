package com.iliev.peter.kata;

import java.util.Arrays;

public class CountingSort13 {

	public static final void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (final int i : a) {
			if (min > i) {
				min = i;
			}

			if (max < i) {
				max = i;
			}
		}

		final int len = max - min + 1;

		final int counts[] = new int[len];

		for (final int i : a) {
			counts[i - min]++;
		}

		int counter = 0;
		for (int i = 0; i < len; i++) {
			Arrays.fill(a, counter, counter + counts[i], i + min);
			counter += counts[i];
		}
	}
}
