package com.iliev.peter.kata;

public class QS2 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length <= 1) {
			return;
		}
		
		sortInternal(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void sortInternal(
			final T[] a, final int start, final int end) {
		
		if (start >= end) {
			return;
		}
		
		int s = start;
		int e = end;
		int pivotIndex = start;
		final T pivotElement = a[pivotIndex];
		
		while (s < e) {
			while (e > s && a[e].compareTo(pivotElement) >= 0) {
				e--;
			}

			if (e > s) {
				swap(a, e, pivotIndex);
				s++;
				pivotIndex = e;
			}
			
			while (s < e && a[s].compareTo(pivotElement) <= 0) {
				s++;
			}
			
			if (s < e) {
				swap(a, s, pivotIndex);
				e--;
				pivotIndex  = s;
			}
		}

		sortInternal(a, start, pivotIndex - 1);
		sortInternal(a, pivotIndex+1, end);
	}
	
	private static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
