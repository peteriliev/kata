package com.iliev.peter.kata;

public class InsertionSort4 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length <= 1) {
			return;
		}
		
		for (int i = 1; i < a.length; i++) {
			final T insertMe = a[i];
			
			int j = i - 1;
			while (j >= 0 && a[j].compareTo(insertMe) > 0) {
				a[j + 1] = a[j];
				j--;
			}
			
			a[j + 1] = insertMe;
		}
		
	}
}
