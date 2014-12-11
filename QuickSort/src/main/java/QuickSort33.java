package main.java;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort33 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	public static <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int end) {
		if (start >= end) {
			return;
		}

		int left = start;
		int pivot = left;
		final T pivotVal = a[pivot];
		int right = end;

		while (left < right) {
			while (right > left && a[right].compareTo(pivotVal) >= 0) {
				right--;
			}

			if (right > left) {
				Collections.swap(Arrays.asList(a), right, pivot);
				pivot = right;
				left++;
			}

			while (left < right && a[left].compareTo(pivotVal) <= 0) {
				left++;
			}

			if (left < right) {
				Collections.swap(Arrays.asList(a), left, pivot);
				pivot = left;
				right--;
			}
		}

		sortInternal(a, start, pivot - 1);
		sortInternal(a, pivot + 1, end);
	}
}
