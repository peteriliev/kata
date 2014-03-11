package com.peter.iliev.kata;

public class InsertionSort7 {

	public static void sort(final Integer[] a, final int from, final int to) {
		final int len = to - from + 1;
		
		if (len <= 1) {
			 return;
		}
		
		for (int i = from + 1; i <= to; i++) {
			final int insertMe = a[i];
			int ptr = i - 1;
			while (ptr >= from && a[ptr].compareTo(insertMe) > 0) {
				a[ptr + 1] = a[ptr];
				ptr--;
			}
			a[ptr + 1] = insertMe;
		}
	}
}
