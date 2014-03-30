package com.iliev.peter.kata;

import com.iliev.peter.kata.utils.Swapper;

public class BubbleSort16 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length < 2) {
			return;
		}

		for (int len = a.length; len > 1; len--) {
			boolean swapped = false;

			for (int i = 0; i + 1 < len; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					Swapper.swap(a, i, i + 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}
}
