package com.peter.iliev.kata;

public class Insert2 {

	public static void sort(final Integer[] a, final int start, final int end) {
		
		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		final int length = end - start + 1;
		if (length > a.length) {
			throw new IllegalArgumentException("Lenghts mismatch");
		}
		
		if (a.length <= 1) {
			return;
		}
		
		for (int i = start + 1; i <= end; i++) {
			final Integer insertMe = a[i];
			int j = i - 1;
			
			while (j >= start && a[j].compareTo(insertMe) > 0) {
				a[j + 1] = a[j];
				j--;
			}

			a[j + 1] = insertMe;
		}
	}
}
