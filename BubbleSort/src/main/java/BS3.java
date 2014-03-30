package com.iliev.peter.kata;

public class BS3 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = a.length; i > 0; i--) {
			for (int j = 0; j + 1 < i; j++) {
				if (a[j].compareTo(a[j+1]) > 0) {
					bubbleUp(a, j, j + 1);
				}
			}
		}
	}
	
	private static <T extends Comparable<T>> void bubbleUp(final T[] a, final int x, final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
