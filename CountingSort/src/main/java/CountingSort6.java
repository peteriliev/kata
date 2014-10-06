package main.java;

import java.util.Arrays;

public class CountingSort6 {

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
		
		final int counts[] = new int[length];
		
		for (int i = 0; i < a.length; i++) {
			counts[a[i] - min]++;
		}
		
		int counter = 0;
		for (int c = 0; c < length; c++) {
			Arrays.fill(a, counter, counter + counts[c], c + min);
			counter += counts[c];
		}
	}
}
