package main.java;

import java.util.Arrays;
import java.util.Collections;

public class CountingSort39 {

	public static void sort(final Integer[] a) {
		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		final int numEleam = max - min + 1;

		final int[] counts = new int[numEleam];

		for (final int i : a) {
			counts[i - min]++;
		}

		int offset = 0;
		for (int i = 0; i < numEleam; i++) {
			Arrays.fill(a, offset, offset + counts[i], i + min);
			offset = offset + counts[i];
		}
	}
}
