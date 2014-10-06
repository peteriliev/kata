package main.java;

import java.util.Arrays;

public class CountingSort14 {

	public static void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (final int i : a) {
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
		}
		
		final int len = max - min + 1;
		final int conts[] = new int[len];
		
		for(final int i : a) {
			conts[i - min]++;
		}
		
		int offset = 0;
		for (int i  = 0; i < len; i++) {
			Arrays.fill(a, offset, offset + conts[i], i + min);
			offset += conts[i];
		}
	}
}
