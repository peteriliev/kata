package main.java;

public class MergeSort18 {
	public static final <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	private static final <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int end) {
		if (start >= end) {
			return;
		}

		final int len = end - start + 1;
		final int middle = start + (len / 2);

		sortInternal(a, start, middle - 1);
		sortInternal(a, middle, end);

		merge(a, start, middle - 1, middle, end);

	}

	private static final <T extends Comparable<T>> void merge(final T[] a, final int s1, final int e1, final int s2,
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

		start1 = s1;
		for (final Object o : tmp) {
			a[start1++] = (T) o;
		}
	}
}
