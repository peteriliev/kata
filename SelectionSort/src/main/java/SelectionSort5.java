package com.iliev.peter.kata;

public class SelectionSort5 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length <= 1) {
			return;
		}
		
		for (int i = 0; i < a.length -1 ; i++) {
			int ptr = i;
			for (int j = i; j < a.length; j++) {
				if (a[j].compareTo(a[ptr]) < 0) {
					ptr = j;
				}
			}
			
			final T tmp = a[ptr];
			a[ptr] = a[i];
			a[i] = tmp;
		}
	}
}
