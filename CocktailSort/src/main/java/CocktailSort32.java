package main.java;

import java.util.Arrays;
import java.util.Collections;

public class CocktailSort32 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		int left = 0;
		int right = a.length;
		boolean swapped = false;

		while (left < right) {

			for (int i = left; i + 1 < right; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					swapped = true;
					Collections.swap(Arrays.asList(a), i + 1, i);
				}
			}

			if (!swapped) {
				break;
			}
			right--;
			swapped = false;

			for (int i = right - 1; i - 1 >= left; i--) {
				if (a[i].compareTo(a[i - 1]) < 0) {
					swapped = true;
					Collections.swap(Arrays.asList(a), i - 1, i);
				}
			}

			if (!swapped) {
				break;
			}
			left++;
			swapped = false;
		}
	}
}
