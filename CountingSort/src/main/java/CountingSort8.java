package main.java;

import java.util.Arrays;

public class CountingSort8 {

	public static void sort(final Integer[] a) {
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
		
		final int length = max - min + 1;
		int counts[] = new int[length];
		
		for (final int i : a) {
			counts[i - min]++;
		}
		
		int offset = 0;
		for (int c = 0; c < length; c++) {
			Arrays.fill(a, offset, offset + counts[c], c + min);
			offset += counts[c];
		}
	}
}
