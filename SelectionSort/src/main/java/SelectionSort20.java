package com.iliev.peter.kata;

import java.util.Arrays;
import java.util.Collections;

public class SelectionSort20 {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j].compareTo(a[min]) < 0) {
					min = j;
				}
			}

			Collections.swap(Arrays.asList(a), i, min);

		}
	}
}
