package main.java;

public class MergeSort2 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	public static <T extends Comparable<T>> void sortInternal(final T[] a,
			final int start, final int end) {

		if (end - start <= 0) {
			return;
		}

		final int middle = start + (end - start + 1) / 2;

		sortInternal(a, start, middle - 1);
		sortInternal(a, middle, end);

		merge(a, start, middle - 1, middle, end);
	}

	public static <T extends Comparable<T>> void merge(final T[] a,
			final int start1, final int end1, final int start2, final int end2) {
		final int length = end2 - start1 + 1;

		@SuppressWarnings("unchecked")
		T[] tmp = (T[]) new Integer[length];

		int index1 = start1;
		int index2 = start2;

		for (int i = 0; i < length; i++) {

			if (index1 > end1) {
				tmp[i] = a[index2++];

			} else if (index2 > end2) {
				tmp[i] = a[index1++];

			} else if (a[index1].compareTo(a[index2]) <= 0) {
				tmp[i] = a[index1++];

			} else {
				tmp[i] = a[index2++];
			}
		}
		int z = start1;
		for (final T x : tmp) {
			a[z++] = x;
		}
	}
}