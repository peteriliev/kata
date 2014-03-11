package com.iliev.peter.kata; 

public class SS3 {

	public static <T extends Comparable<T>> void sort(T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < a.length; i++) {
			T minElement = a[i];
			int minIndex = i;
			
			for (int j = i; j < a.length; j++) {
				if (a[j].compareTo(minElement) < 0) {
					minElement = a[j];
					minIndex = j;
				}
			}
			
			swap(a, i, minIndex);
		}
	}
	
	private static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
		if (x == y) {
			return;
		}
		
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
	

}
