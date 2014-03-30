package com.iliev.peter.kata;

import com.iliev.peter.kata.utils.Swapper;

public class QuickSort16 {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		sortInternal(a, 0, a.length - 1);

	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a, final int from, final int to) {
		if (from >= to) {
			return;
		}
		
		int left = from;
		int pivot = left;
		final T pivotValue = a[pivot];
		int right = to;

		while (left < right) {
			while (right > left && a[right].compareTo(pivotValue) >= 0) {
				right--;
			}

			if (right > left) {
				Swapper.swap(a, right, pivot);
				pivot = right;
				left++;
			}

			while (left < right && a[left].compareTo(pivotValue) <= 0) {
				left++;
			}

			if (left < right) {
				Swapper.swap(a, left, pivot);
				pivot = left;
				right--;
			}
		}

		sortInternal(a, from, pivot - 1);
		sortInternal(a, pivot + 1, to);
	}
}
