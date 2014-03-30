package com.iliev.peter.kata;

public class QuickSort8 {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		if (1 >= a.length) {
			return;
		}

		sortInternal(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a,
			final int start, final int end) {
		
		if (start >= end) {
			return;
		}
		
		int left = start;
		int right = end;
		int pivot = left;
		final T pivotValue = a[pivot];

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

		sortInternal(a, start, pivot - 1);
		sortInternal(a, pivot + 1, end);
	}

	private static <T extends Comparable<T>> void swap(final T[] a,
			final int i, final int j) {
		final T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
