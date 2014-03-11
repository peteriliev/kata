package com.iliev.peter.kata;

import java.util.Arrays;
import java.util.Collections;

public class SelectionSort21 {

	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		for (int j = a.length - 1; j > 0; j--) {
			int maxIndex = j;
			for (int i = 0; i < j; i++ ) {
				if (a[maxIndex].compareTo(a[i]) < 0) {
					maxIndex = i;
				}
			}
			Collections.swap(Arrays.asList(a), maxIndex, j);
		}
	}
}
