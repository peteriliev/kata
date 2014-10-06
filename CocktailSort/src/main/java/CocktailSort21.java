package main.java;

import java.util.Arrays;
import java.util.Collections;

public class CocktailSort21 {
	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		int left = 0;
		int right = a.length;

		while (left < right) {
			for (int i = left; i + 1 < right; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					Collections.swap(Arrays.asList(a), i, i + 1);
				}
			}

			for (int i = right - 1; i - 1 >= left; i--) {
				if (a[i].compareTo(a[i - 1]) < 0) {
					Collections.swap(Arrays.asList(a), i, i - 1);
				}
			}
		}
	}
}