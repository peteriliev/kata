package main.java;

import java.util.Arrays;
import java.util.Collections;

public class SelectionSort33 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		for (int i = 0; i < a.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j].compareTo(a[minIndex]) < 0) {
					minIndex = j;
				}
			}
			Collections.swap(Arrays.asList(a), minIndex, i);
		}
	}
}
