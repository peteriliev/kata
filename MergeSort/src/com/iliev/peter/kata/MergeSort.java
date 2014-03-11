package com.iliev.peter.kata;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a,
			final int start, final int end) {

		if (end - start <= 0) {
			return;
		}

		final int middle = start + (end - start + 1) / 2;

		sortInternal(a, start, middle - 1);
		sortInternal(a, middle, end);

		merge(a, start, middle - 1, middle, end);
	}

	private static <T extends Comparable<T>> void merge(final T[] a,
			final int start1, final int end1, final int start2, final int end2) {

		final int newSize = end2 - start1 + 1;
		List<T> newA = new ArrayList<T>(newSize);

		int index1 = start1;
		int index2 = start2;

/*		int j = 0;
		while (index1 <= end1 || index2 <= end2) {
			while(index1 <= end1 && a[index1].compareTo(a[index2]) <= 0) {
				newA.add(j++, a[index1]);
				index1++;
			}
			
			while(index2 <= end2 && a[index2].compareTo(a[index1]) <= 0) {
				newA.add(j++, a[index2]);
				index2++;
			}
		}
*/
		for (int i = 0; i < newSize; i++) {
			if (index1 <= end1
					&& (index2 > end2 || a[index1].compareTo(a[index2]) <= 0)) {

				newA.add(i, a[index1]);
				index1++;
			} else {
				newA.add(i, a[index2]);
				index2++;
			}
		}
		int m = 0;
		for (int i = start1; i <= end2; i++) {
			a[i] = newA.get(m++);
		}
	}
}