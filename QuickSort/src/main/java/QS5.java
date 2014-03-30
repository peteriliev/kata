package com.iliev.peter.kata;

public class QS5 {

	public static<T extends Comparable<T>> void sort(final T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		if (a.length <= 1) {
			return;
		}
		
		sortInternal(a, 0, a.length -1);
	
	}
	
	public static<T extends Comparable<T>> void sortInternal(final T[] a, final int s, final int e) {
		if (s >= e) {
			return;
		}
		
		int left = s;
		int right = e;
		int pivot = left;
		final T pivotValue =a[left];
		
		while (left < right) {
			while (right > left && a[right].compareTo(pivotValue) >= 0) {
				right--;
			}
			
			if (right > left) {
				swap(a, right, pivot);
				pivot = right;
				left++;
			}
			
			while (left < right && a[left].compareTo(pivotValue) <= 0) {
				left++;
			}
			
			if (left < right) {
				swap(a, left, pivot);
				pivot = left;
				right--;
			}
			
		}
		
		sortInternal(a, s, pivot - 1);
		sortInternal(a, pivot + 1, e);
	}
	
	public static<T extends Comparable<T>> void swap(final T[] a, final int s, final int e) {
		final T tmp = a[s];
		a[s] = a[e];
		a[e] = tmp;
	}
}
