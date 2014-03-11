package com.iliev.peter.kata;

public class CombSort6 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (1 >= a.length) {
			return;
		}

		int gap = a.length;
		boolean swapped = true;

		while (swapped || gap > 1) {
			swapped = false;
			gap = (int) (gap / 1.3);
			if (gap < 1) {
				gap = 1;
			}

			for (int i = 0; i + gap < a.length; i++) {
				if (a[i].compareTo(a[i + gap]) > 0) {
					swap(a, i, i + gap);
					swapped = true;
				}

			}
		}
	}

	private static <T extends Comparable<T>> void swap(final T[] a,
			final int x, final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
