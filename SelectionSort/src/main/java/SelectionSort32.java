package main.java;

import java.util.Arrays;
import java.util.Collections;

public class SelectionSort32 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		final int last = a.length - 1;
		for (int i = last; i > 0; i--) {
			int maxIndex = i;
			for (int j = i - 1; j >= 0; j--) {
				if (a[j].compareTo(a[maxIndex]) > 0) {
					maxIndex = j;
				}
			}

			Collections.swap(Arrays.asList(a), i, maxIndex);
		}
	}
}
