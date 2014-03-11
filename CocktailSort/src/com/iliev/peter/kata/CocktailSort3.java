package com.iliev.peter.kata;

public class CocktailSort3 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length <= 1) {
			return;
		}

		boolean swapped = true;

		int top = a.length - 1;
		int bottom = 0;
		while (swapped) {
			swapped = false;

			for (int i = bottom; i + 1 <= top; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					swap(a, i, i + 1);
					swapped = true;
				}
			}
			top--;
			if (!swapped) {
				break;
			}

			swapped = false;
			for (int j = top; j - 1 >= bottom; j--) {
				if (a[j].compareTo(a[j - 1]) < 0) {
					swap(a, j, j - 1);
					swapped = true;
				}
			}
			bottom++;
			if (!swapped) {
				break;
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
