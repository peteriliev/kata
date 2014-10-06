package main.java;

import com.iliev.peter.kata.utils.Swapper;

public class CocktailSort16 {

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
					Swapper.swap(a, i, i + 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
			right--;

			swapped = false;
			for (int i = right - 1; i - 1 >= left; i--) {
				if (a[i].compareTo(a[i - 1]) < 0) {
					Swapper.swap(a, i, i - 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
			left++;

		}
	}
}
