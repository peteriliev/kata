package com.iliev.peter.kata;

public class CombSort {

	// Test git
	public static <T extends Comparable<T>> void sort(T[] a) {

		if (a == null) {
			throw new IllegalArgumentException();
		}

		int gap = a.length;
		boolean swapped = true;

		while (gap > 1 || swapped) {
			gap = (int) (gap / 1.3);
			if (gap < 1) {
				gap = 1;
			}
			swapped = false;

			for (int i = 0; i + gap < a.length; i++) {
				if (a[i].compareTo(a[i + gap]) > 0) {
					swapped = true;
					final T element = a[i];
					a[i] = a[i + gap];
					a[i + gap] = element;
				}

			}

		}

	}

}
