package main.java;

import java.util.Arrays;
import java.util.Collections;

public class SelectionSort22 {
	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		for (int i = a.length - 1; i > 0; i--) {
			int maxIndex = i;

			for (int j = i - 1; j >= 0; j--) {
				if (a[maxIndex].compareTo(a[j]) < 0) {
					maxIndex = j;
				}
			}

			Collections.swap(Arrays.asList(a), i, maxIndex);
		}
	}
}
