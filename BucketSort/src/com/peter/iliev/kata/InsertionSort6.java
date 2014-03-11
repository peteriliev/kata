package com.peter.iliev.kata;

public class InsertionSort6 {

	public static void sort(final Integer[] a, final int from, final int to) {
		final int length = to - from + 1;
		if (length <= 1) {
			return;
		}
		
		for (int i = from + 1; i <= to; i++) {
			final int insertMe = a[i];
			int ptr = i - 1;
			
			while (ptr >= from && a[ptr] > insertMe) {
				a[ptr + 1] = a[ptr];
				ptr--;
			}
			
			a[ptr + 1] = insertMe;
		}
	}
}
