package main.java;

import java.util.Arrays;
import java.util.Collections;

public class BubbleSort17 {
	public static <T extends Comparable<T>> void sort(final T[] a) {

		for (int i = a.length; i > 0; i--) {
			boolean swapped = false;
			for (int j = 0; j + 1 < i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					Collections.swap(Arrays.asList(a), j, j + 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}
}
