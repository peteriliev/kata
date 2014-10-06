package main.java;

import java.util.ArrayList;
import java.util.List;

public class MS3 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a,
			final int start, final int end) {

		if (start >= end) {
			return;
		}

		final int middle = (end - start + 1) / 2 + start;

		sortInternal(a, start, middle - 1);
		sortInternal(a, middle, end);

		merge(a, start, middle - 1, middle, end);
	}

	private static <T extends Comparable<T>> void merge(final T[] a,
			final int s1, final int e1, final int s2, final int e2) {

		final int length = e2 - s1 + 1;
		final List<T> tmp = new ArrayList<T>(length);

		int ptr1 = s1;
		int ptr2 = s2;
		for (int i = 0; i < length; i++) {
			if (ptr1 > e1) {
				tmp.add(i, a[ptr2++]);
			} else if (ptr2 > e2) {
				tmp.add(i, a[ptr1++]);
			} else if (a[ptr1].compareTo(a[ptr2]) < 0) {
				tmp.add(i, a[ptr1++]);
			} else {
				tmp.add(i, a[ptr2++]);
			}
		}

		int ptr3 = s1;
		for (final T e : tmp) {
			a[ptr3++] = e;
		}
	}
}
