package com.iliev.peter.kata;

import java.util.Arrays;

public class CS5 {

	public static void sort(final Integer[] a) {
		if (a.length <= 1) {
			return;
		}
		
		int min = a[0];
		int max = a[0];
		for (final int i : a) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		
		final int legnth = max - min + 1;
		final int[] keys = new int[legnth];
		
		for (final int i : a) {
			keys[i - min]++;
		}
		
		int counter = 0;
		for (int k = 0; k < keys.length; k++) {
			Arrays.fill(a, counter, counter + keys[k], k + min);
			counter += keys[k];
		}
		
	}
}
