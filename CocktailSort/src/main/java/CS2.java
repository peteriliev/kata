package com.iliev.peter.kata;

public class CS2 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		int start = 0;
		int end = a.length - 1;
		boolean swapped;
		while (start < end) {

			swapped = false;
			for (int i = start; i < end; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					final T tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
					swapped = true;
				}
			}
			end--;
			if (!swapped) {
				break;
			}

			for (int j = end; j > start; j--) {
				if (a[j].compareTo(a[j - 1]) < 0) {
					T tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
					swapped = true;
				}
			}
			start++;
			if (!swapped) {
				break;
			}

		}
	}
}
