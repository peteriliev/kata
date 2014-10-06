package main.java;

import java.util.Arrays;
import java.util.Collections;

public class CocktailSort17 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		int left = 0;
		int right = a.length - 1;

		while (left < right) {
			boolean swapped = false;
			for (int i = left; i + 1 <= right; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					Collections.swap(Arrays.asList(a), i, i + 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
			right--;

			swapped = false;
			for (int i = right; i - 1 >= left; i--) {
				if (a[i].compareTo(a[i - 1]) < 0) {
					Collections.swap(Arrays.asList(a), i, i - 1);
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
