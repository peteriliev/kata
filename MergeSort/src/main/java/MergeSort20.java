package main.java;

public class MergeSort20 {
	public static final <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	public static final <T extends Comparable<T>> void sortInternal(final T[] a, final int s, final int e) {
		final int len = e - s + 1;
		if (len < 2) {
			return;
		}

		final int middle = s + (len / 2);

		sortInternal(a, s, middle - 1);
		sortInternal(a, middle, e);

		merge(a, s, middle - 1, middle, e);
	}

	public static final <T extends Comparable<T>> void merge(final T[] a, final int s, final int e, final int s2,
			final int e2) {
		final int len = e2 - s + 1;
		final Object[] tmp = new Object[len];

		int start1 = s;
		int start2 = s2;

		for (int i = 0; i < len; i++) {
			if (start1 > e) {
				tmp[i] = a[start2++];
			} else if (start2 > e2) {
				tmp[i] = a[start1++];
			} else if (a[start1].compareTo(a[start2]) < 0) {
				tmp[i] = a[start1++];
			} else {
				tmp[i] = a[start2++];
			}
		}
		start1 = s;
		for (final Object o : tmp) {
			a[start1++] = (T) o;
		}
	}
}
