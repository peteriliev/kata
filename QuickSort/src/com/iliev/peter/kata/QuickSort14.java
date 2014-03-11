package com.iliev.peter.kata;

import com.iliev.peter.kata.utils.Swapper;

public class QuickSort14 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length < 2) {
			return;
		}

		sortInternal(a, 0, a.length - 1);
	}

	public static <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int endInc) {
		if (start >= endInc) {
			return;
		}

		int left = start;
		int right = endInc;
		int pivot = left;
		final T pivotValue = a[pivot];

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

		sortInternal(a, start, pivot - 1);
		sortInternal(a, pivot + 1, endInc);

	}
}
