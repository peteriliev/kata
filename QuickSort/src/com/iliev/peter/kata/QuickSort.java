package com.iliev.peter.kata;

public final class QuickSort {
	private QuickSort() {
	}
	
	public static <T extends Comparable<T>> void sort(T[] a) {
		verify(a);
		
		if (!requiresSorting(a)) {
			return;
		}
		
		
		sortInternal(a, 0, a.length - 1);
	}
	
	private static <T extends Comparable<T>> void sortInternal(T[] a, final int start, final int end) {
		assert(a != null);
		assert(start >= 0 && start < a.length);
		assert(end >= 0 && end < a.length);
		
		if (start >= end) {
			return;
		}
		
		int left = start;
		int right = end;
		int pivot = start;
		T pivotValue = a[pivot];
		
		while (left < right) {
			while (a[right].compareTo(pivotValue) >= 0 && right > left) {
				right--;
			}
			
			if (right > left) {
				swap(a, right, pivot);
				pivot = right;
			}
			
			while(a[left].compareTo(pivotValue) <= 0 && left < right) {
				left++;
			}

			if (left < right) {
				swap(a, left, pivot);
				pivot = left;
			}
		}
		
		sortInternal(a, start, pivot - 1);
		sortInternal(a, pivot + 1, end);
	}	
	
	private static <T extends Comparable<T>> void swap(T[] a, final int start, final int end) {
		T tmp = a[start];
		a[start] = a[end];
		a[end] = tmp;
	}

	private static <T extends Comparable<T>> void verify(T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}
	}
	
	private static <T extends Comparable<T>> Boolean requiresSorting(T[] a) {
		assert(a != null);
		return a.length > 1;
	}	
}
