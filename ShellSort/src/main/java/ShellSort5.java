package com.iliev.peter.kata;

public class ShellSort5 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		final int[] gaps = { 701, 301, 132, 57, 23, 10, 4, 1 };
		
		for (final int gap : gaps) {
			if (gap >= a.length) {
				continue;
			}
			
			for (int i = 0; i < gap; i++) {
				for (int j = i + gap; j < a.length; j += gap) {
					final T insertMe = a[j];
					int foo = j - gap;
					while (foo >= i && a[foo].compareTo(insertMe) > 0) {
						a[foo + gap] = a[foo];
						foo -= gap;
					}
					
					a[foo + gap] = insertMe;
				}
			}
		}
	}
}
