package com.iliev.peter.kata;

public class CocktailSort10 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length < 2) {
			return;
		}

		int left = 0;
		int right = a.length;

		while (left < right) {
			boolean swapped = false;
			for (int i = left; i + 1 < right; i++) {
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
			for (int i = right; i - 1 >= left; i--) {
				if (a[i].compareTo(a[i - 1]) < 0) {
					swap(a, i, i - 1);
					swapped = true;
				}
			}
			left++;
			if (!swapped) {
				break;
			}

		}
	}

	public static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;

	}
}
