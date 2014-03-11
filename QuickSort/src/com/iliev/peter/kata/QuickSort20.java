package com.iliev.peter.kata;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort20 {
	public static final <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	public static final <T extends Comparable<T>> void sortInternal(final T[] a, final int s, final int e) {
		if (s >= e) {
			return;
		}

		int right = e;
		int left = s;
		int pivot = left;
		final T pivotValue = a[pivot];

		while (left < right) {
			while (right > left && a[right].compareTo(pivotValue) >= 0) {
				right--;
			}

			if (right > left) {
				Collections.swap(Arrays.asList(a), right, pivot);
				pivot = right;
				left++;
			}

			while (left < right && a[left].compareTo(pivotValue) <= 0) {
				left++;
			}

			if (left < right) {
				Collections.swap(Arrays.asList(a), left, pivot);
				pivot = left;
				right--;
			}
		}

		sortInternal(a, s, pivot - 1);
		sortInternal(a, pivot + 1, e);
	}
}
