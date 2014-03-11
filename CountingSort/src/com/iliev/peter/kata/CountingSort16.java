package com.iliev.peter.kata;

import java.util.Arrays;

public class CountingSort16 {

	public static void sort(final Integer[] a) {
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

		final int counts[] = new int[max - min + 1];
		for (final int i : a) {
			counts[i - min]++;
		}

		int offset = 0;
		for (int i = 0; i < counts.length; i++) {
			Arrays.fill(a, offset, offset + counts[i], i + min);
			offset += counts[i];
		}
	}
}
