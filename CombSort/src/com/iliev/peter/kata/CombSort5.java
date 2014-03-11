package com.iliev.peter.kata;

public class CombSort5 {
	public static <T extends Comparable<T>> void sort(final T[] a) {

		boolean swapped = true;
		int gap = a.length;
		while (swapped || gap > 1) {
			swapped = false;
			gap = (int) (gap / 1.3);
			if (gap < 1) {
				gap = 1;
			}
			
			for (int i = 0; i + gap < a.length; i++) {
				if (a[i].compareTo(a[i + gap]) > 0) {
					final T tmp = a[i];
					a[i] = a[i + gap];
					a[i + gap] = tmp;
					swapped = true;
				}
			}
		}
	}
}
