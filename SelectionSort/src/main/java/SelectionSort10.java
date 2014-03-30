package com.iliev.peter.kata;

public class SelectionSort10 {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		for (int i = 0; i + 1 < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j].compareTo(a[min]) < 0) {
					min = j;
				}
			}
			swap(a, i, min);
		}
	}

	public static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;

	}
}
