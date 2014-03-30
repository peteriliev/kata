package com.iliev.peter.kata;

import java.util.Arrays;
import java.util.Collections;

public class SelectionSort26 {
	public static <T extends Comparable<T>> void sort(final T[] a)
	{

		for (int i = 0; i < a.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[minIndex].compareTo(a[j]) > 0) {
					minIndex = j;
				}
			}
			Collections.swap(Arrays.asList(a), i, minIndex);
		}
	}
}
