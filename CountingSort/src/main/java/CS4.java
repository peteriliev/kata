package main.java;

import java.util.Arrays;

public class CS4 {

	public static void sort(final Integer[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		if (a.length <= 1) {
			return;
		}
		
		int min = a[0];
		int max = a[0];
		
		for (final Integer i : a) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		
		final int length = max - min + 1;
		
		final int[] keys = new int[length];
		
		for (final Integer i: a) {
			keys[i - min]++;
		}
		
		int counter = 0;
		
		for (int k = 0; k < keys.length; k++) {
			Arrays.fill(a, counter, counter + keys[k], k + min);
			counter += keys[k];
		}
	}
}