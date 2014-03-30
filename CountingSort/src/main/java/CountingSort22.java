package com.iliev.peter.kata;

import java.util.Arrays;
import java.util.Collections;

public class CountingSort22 {

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));

		final int len = max - min + 1;

		final int[] counts = new int[len];

		for (final int i : a) {
			counts[i - min]++;
		}

		int offset = 0;
		for (int i = 0; i < len; i++) {
			Arrays.fill(a, offset, offset + counts[i], i + min);
			offset += counts[i];
		}
	}
}
