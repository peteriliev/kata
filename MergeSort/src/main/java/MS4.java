package com.iliev.peter.kata;

import java.util.ArrayList;
import java.util.List;

public class MS4 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a,
			final int s, final int e) {
		final int length = e - s + 1;
		if (length <= 1) {
			return;
		}

		final int m = s + length / 2;

		sortInternal(a, s, m - 1);
		sortInternal(a, m, e);

		merge(a, s, m - 1, m, e);
	}

	private static <T extends Comparable<T>> void merge(final T[] a,
			final int s1, final int e1, final int s2, final int e2) {

		final int size = e2 - s1 + 1;
		final List<T> list = new ArrayList<T>(size);

		int index1 = s1;
		int index2 = s2;

		for (int i = 0; i < size; i++) {
			if (index1 > e1) {
				list.add(i, a[index2++]);
			} else if (index2 > e2) {
				list.add(i, a[index1++]);
			} else if (a[index1].compareTo(a[index2]) < 0) {
				list.add(i, a[index1++]);
			} else {
				list.add(i, a[index2++]);
			}
		}

		index1 = s1;
		for (final T t : list) {
			a[index1++] = t;
		}
	}
}
