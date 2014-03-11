package com.iliev.peter.kata;

public class QS4 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		
		sortInternal(a, 0, a.length - 1);
	}

	public static <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int end) {
		if (start >= end) {
			return;
		}
		
		int s = start;
		int e = end;
		int pivot = start;
		final T pivotValue = a[pivot];
		
		while (s < e) {
			
			while (e > s && a[e].compareTo(pivotValue) >= 0) {
				e--;
			}
			
			if (e > s) {
				swap(a, pivot, e);
				pivot = e;
				s++;
			}
			
			while (s < e && a[s].compareTo(pivotValue) <= 0) {
				s++;
			}
			
			if (s < e) {
				swap(a, pivot, s);
				pivot = s;
				e--;
			}
		}
		
		sortInternal(a, start, pivot - 1);
		sortInternal(a, pivot + 1, end);
	}
	
	private static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
