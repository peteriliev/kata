package com.iliev.peter.kata;

public class CombSort4 {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		int s = 0;
		int e = a.length;

		boolean swapped;
		while (s < e) {
			swapped = false;
			for (int i = s; i + 1 < e; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					swap(a, i, i + 1);
					swapped = true;
				}
			}
			e--;
			if (!swapped) {
				break;
			}

			swapped = false;
			for (int j = e; j - 1 >= s; j--) {
				if (a[j].compareTo(a[j - 1]) < 0) {
					swap(a, j, j - 1);
					swapped = true;
				}
			}
			s++;
			if (!swapped) {
				break;
			}
		}
	}

	public static <T extends Comparable<T>> void swap(final T[] a, final int x,
			final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
