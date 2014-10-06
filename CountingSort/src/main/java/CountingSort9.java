package main.java;

import java.util.Arrays;

public class CountingSort9 {

	public static void sort(final Integer[] a) {
		if (1 >= a.length) {
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
		final int[] counts = new int[len];
		
		for (final int i : a) {
			counts[i - min]++;
		}
		
		int offset = 0;
		for (int c = 0; c < len; c++) {
			Arrays.fill(a, offset, offset + counts[c], c + min);
			offset += counts[c];
		}

	}
}
