package main.java;

import java.util.Arrays;

public class CountingSort7 {

	public static void sort(final Integer[] a) {
		if (a.length <= 1) {
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
		
		final int lenght = max - min + 1;
		
		int counts[] = new int[lenght];
		
		for (int i = 0; i < a.length; i++) {
			counts[a[i] - min]++;
		}
		
		int counter = 0;
		for (int c = 0; c < counts.length; c++) {
			Arrays.fill(a, counter, counter + counts[c], c + min);
			counter += counts[c];
		}
	}
}
