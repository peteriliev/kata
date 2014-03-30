package com.iliev.peter.kata;

import com.iliev.peter.kata.utils.Swapper;

public class SS4 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		for (int i = 0; i < a.length; i++) {

			int minIndex = i;

			for (int j = i + 1; j < a.length; j++) {
				if (a[j].compareTo(a[minIndex]) < 0) {
					minIndex = j;
				}
			}

			Swapper.swap(a, i, minIndex);
		}
	}
}
