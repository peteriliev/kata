package main.java;

import java.util.Arrays;
import java.util.Collections;

public class BubbleSort32 {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		final int last = a.length - 1;
		boolean swapped = false;

		for (int i = 0; i < last; i++) {
			swapped = false;
			for (int j = last; j - 1 >= i; j--) {
				if (a[j].compareTo(a[j - 1]) < 0) {
					Collections.swap(Arrays.asList(a), j, j - 1);
					swapped = true;
				}
			}

			if (!swapped) {
				break;
			}
		}
	}
}
