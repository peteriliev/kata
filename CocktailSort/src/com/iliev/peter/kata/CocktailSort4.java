package com.iliev.peter.kata;

public class CocktailSort4 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length < 2) {
			return;
		}

		int left = 0;
		int right = a.length - 1;

		while (left < right) {
			boolean swapped = false;
			for (int i = left; i + 1 <= right; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					swap(a, i, i + 1);
					swapped = true;
				}
			}
			right--;
			if (!swapped) {
				break;
			}

			swapped = false;
			for (int j = right; j - 1 >= left; j--) {
				if (a[j].compareTo(a[j - 1]) < 0) {
					swap(a, j, j - 1);
					swapped = true;
				}
			}
			left++;
			if (!swapped) {
				break;
			}

		}
	}

	public static <T extends Comparable<T>> void swap(final T[] a,
			final int x1, final int x2) {
		final T tmp = a[x1];
		a[x1] = a[x2];
		a[x2] = tmp;
	}
}
