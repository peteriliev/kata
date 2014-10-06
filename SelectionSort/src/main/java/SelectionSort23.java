package main.java;

import java.util.Arrays;
import java.util.Collections;

public class SelectionSort23 {
	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		for (int j = 0; j < a.length - 1; j++) {
			int minIndex = j;
			for (int i = j + 1; i < a.length; i++) {
				if (a[i].compareTo(a[minIndex]) < 0) {
					minIndex = i;
				}
			}
			Collections.swap(Arrays.asList(a), j, minIndex);
		}
	}
}
