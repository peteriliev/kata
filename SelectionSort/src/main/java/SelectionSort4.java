package com.iliev.peter.kata;

public class SelectionSort4 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a == null)
		{
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < a.length - 1; i++)
		{
			int minIndex = i;
			
			for (int j = i + 1; j < a.length; j++) {
				if (a[j].compareTo(a[minIndex]) < 0) {
					minIndex = j;
				}
			}
			
			if (minIndex != i) {
				final T tmp = a[minIndex];
				a[minIndex] = a[i];
				a[i] = tmp;
			}
		}
	}

}
