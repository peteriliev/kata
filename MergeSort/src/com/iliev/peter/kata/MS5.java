package com.iliev.peter.kata;

public class MS5 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}
	
	private static <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int end) {
		if (start >= end) {
			return;
		}
		
		final int length = end - start + 1;
		final int middle = start + (length-1) / 2;
		
		sortInternal(a, start, middle);
		sortInternal(a, middle + 1, end);
		
		merge(a, start, middle, middle + 1, end);
	}
	
	private static <T extends Comparable<T>> void merge(
			final T[] a, final int s1, final int e1, final int s2, final int e2) {
		
		int start1 = s1;
		int start2 = s2;
		final int length = e2 - s1 + 1;
		final Object[] tmp = new Object[length];
		
		for (int i = 0; i < length; i++) {
			if (start1 > e1) {
				tmp[i] = a[start2++]; 
			} else if (start2 > e2) {
				tmp[i] = a[start1++];
			} else if (a[start1].compareTo(a[start2]) <= 0) {
				tmp[i] = a[start1++];
			} else {
				tmp[i] = a[start2++];
			}
		}
		
		start1 = s1;
		for (final Object t : tmp) {
			a[start1++] = (T)t;
		}
	}
}
