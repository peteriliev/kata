package main.java;

import java.util.Arrays;
import java.util.Collections;

public class SelectionSort17 {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		for (int i = 0; i < a.length; i++) {
			int minIndex = i;
			for (int j = i; j < a.length; j++) {
				if (a[j].compareTo(a[minIndex]) < 0) {
					minIndex = j;
				}
			}
			Collections.swap(Arrays.asList(a), i, minIndex);
		}
	}
}
