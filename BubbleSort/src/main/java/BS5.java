package com.iliev.peter.kata;

import com.iliev.peter.kata.utils.Swapper;

public class BS5 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		for (int i = a.length; i > 0; i--) {
			for (int j = 0; j + 1 < i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					Swapper.swap(a, j, j + 1);
				}
			}
		}
	}
}