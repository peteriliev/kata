package com.iliev.peter.kata;

public class MergeSort17 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int endInc) {
		final int len = endInc - start + 1;

		if (len < 2) {
			return;
		}

		final int middle = start + (len / 2);

		sortInternal(a, start, middle - 1);
		sortInternal(a, middle, endInc);

		merge(a, start, middle - 1, middle, endInc);
	}

	private static <T extends Comparable<T>> void merge(final T[] a, final int s1, final int e1, final int s2,
			final int e2) {
		final int len = e2 - s1 + 1;
		final Object[] tmp = new Object[len];

		int start1 = s1;
		int start2 = s2;
		for (int i = 0; i < len; i++) {
			if (start1 > e1) {
				tmp[i] = a[start2++];
			} else if (start2 > e2) {
				tmp[i] = a[start1++];
			} else if (a[start1].compareTo(a[start2]) < 0) {
				tmp[i] = a[start1++];
			} else {
				tmp[i] = a[start2++];
			}
		}

		int ptr = s1;
		for (final Object obj : tmp) {
			a[ptr++] = (T) obj;
		}
	}
}
