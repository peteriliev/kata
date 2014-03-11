package com.iliev.peter.kata;

import java.util.Arrays;

public class CountingSort17 {

	public static void sort(final Integer[] a) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (final int i : a) {
			if (i < min) {
				min = i;
			}
			if (i > max) {
				max = i;
			}
		}

		int span = max - min + 1;
		int counts[] = new int[span];

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
