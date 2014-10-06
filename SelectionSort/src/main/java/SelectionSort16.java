package main.java;

import com.iliev.peter.kata.utils.Swapper;

public class SelectionSort16 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length < 2) {
			return;
		}
		
		for (int i = 0; i < a.length; i++) {
			int minIndex = i;
			for (int j = i; j < a.length; j++) {
				if (a[j].compareTo(a[minIndex]) < 0) {
					minIndex = j;
				}
			}
			Swapper.swap(a, i, minIndex);
		}
	}
}
