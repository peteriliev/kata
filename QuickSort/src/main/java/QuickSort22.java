package main.java;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort22 {
	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		sortInternal(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a, final int s, final int e)
	{

		if (s >= e) {
			return;
		}

		int left = s;
		int pivot = left;
		final T pivotValue = a[pivot];
		int right = e;

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
