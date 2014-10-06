package main.java;

public class QuickSort5 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		if (a.length <= 1) {
			return;
		}

		sortInternal(a, 0, a.length - 1);
	}

	public static <T extends Comparable<T>> void sortInternal(final T[] a,
			final int s, final int e) {
		if (s >= e) {
			return;
		}

		int start = s;
		int end = e;
		int pivot = s;
		final T pivotValue = a[pivot];

		while (start < end) {
			while (end > start && a[end].compareTo(pivotValue) >= 0) {
				end--;
			}

			if (end > start) {
				swap(a, pivot, end);
				pivot = end;
				start++;
			}

			while (start < end && a[start].compareTo(pivotValue) <= 0) {
				start++;
			}

			if (start < end) {
				swap(a, pivot, start);
				pivot = start;
				end--;
			}
		}

		sortInternal(a, s, pivot - 1);
		sortInternal(a, pivot + 1, e);

	}

	public static <T extends Comparable<T>> void swap(final T[] a, final int s,
			final int e) {
		final T tmp = a[s];
		a[s] = a[e];
		a[e] = tmp;
	}
}