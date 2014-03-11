package com.iliev.peter.kata;

public class QS3 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		
		sortInternal(a, 0, a.length -1);
		
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a, final int s, final int e) {
		
		if (s >= e) {
			return;
		}
		
		int left = s;
		int right = e;
		int pivot = left;
		final T pVal = a[pivot];

		while (left < right) {
			
			while (right > left && a[right].compareTo(pVal) >= 0) {
				right--;
			}
			
			if (right > left) {
				swap(a, right, pivot);
				pivot = right;
				left++;
			}
			
			while (left < right && a[left].compareTo(pVal) <= 0) {
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
	
	private static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
