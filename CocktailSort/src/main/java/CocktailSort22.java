package main.java;

import java.util.Arrays;
import java.util.Collections;

public class CocktailSort22 {
	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		int left = 0;
		int right = a.length - 1;

		boolean swapped;
		while (left < right) {

			swapped = false;
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
