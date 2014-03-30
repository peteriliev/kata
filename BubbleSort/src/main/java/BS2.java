package com.iliev.peter.kata;

public class BS2 {

	public static <T extends Comparable<T>> void sort(T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		if (!requiresSorting(a)) {
			return;
		}
		
		Boolean swapped = true;
		while(swapped) {
			swapped = false;
			
			for (int i = a.length - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (a[j].compareTo(a[j+1]) >= 0) {
						swap(a, j, j+1);
						swapped = true;
					}
				}
			}
		}
	}

	private static <T extends Comparable<T>> Boolean requiresSorting(T[] a) {
		return a.length > 1;
	}

	private static <T extends Comparable<T>> void swap(T[] a, int i, int j) {
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
