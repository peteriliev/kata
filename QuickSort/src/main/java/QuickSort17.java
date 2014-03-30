package com.iliev.peter.kata;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort17 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int endInc) {
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
				Collections.swap(Arrays.asList(a), pivot, right);
				pivot = right;
				left++;
			}

			while (left < right && a[left].compareTo(pivotValue) <= 0) {
				left++;
			}

			if (left < right) {
				Collections.swap(Arrays.asList(a), pivot, left);
				pivot = left;
				right--;
			}
		}

		sortInternal(a, start, pivot - 1);
		sortInternal(a, pivot + 1, endInc);
	}
}