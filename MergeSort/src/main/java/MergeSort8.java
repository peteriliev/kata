package main.java;

import java.util.ArrayList;
import java.util.List;

public class MergeSort8 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length <= 1) {
			return;
		}
		sortInternal(a, 0, a.length - 1);
	}

	public static <T extends Comparable<T>> void sortInternal(final T[] a,
			final int from, final int toInc) {
		final int length = toInc - from + 1;
		if (length <= 1) {
			return;
		}

		final int middle = from + (length / 2);

		sortInternal(a, from, middle - 1);
		sortInternal(a, middle, toInc);

		merge(a, from, middle - 1, middle, toInc);
	}

	public static <T extends Comparable<T>> void merge(final T[] a,
			final int s1, final int e1, final int s2, final int e2) {
		final int lenght = e2 - s1 + 1;
		final List<T> tmp = new ArrayList<>();

		int ptr1 = s1;
		int ptr2 = s2;

		for (int i = 0; i < lenght; i++) {
			if (ptr1 > e1) {
				tmp.add(a[ptr2++]);
			} else if (ptr2 > e2) {
				tmp.add(a[ptr1++]);
			} else if (a[ptr1].compareTo(a[ptr2]) < 0) {
				tmp.add(a[ptr1++]);
			} else {
				tmp.add(a[ptr2++]);
			}
		}

		ptr1 = s1;
		for (final T t : tmp) {
			a[ptr1++] = t;
		}
	}
}
