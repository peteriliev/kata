package com.iliev.peter.kata;

public class HeapSort9 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (1 >= a.length) {
			return;
		}

		for (int i = 1; i < a.length; i++) {
			int index = i;
			int parent = getParent(index);
			while (NULL_INDEX != parent && a[index].compareTo(a[parent]) > 0) {
				swap(a, index, parent);
				index = parent;
				parent = getParent(index);
			}
		}

		for (int i = a.length - 1; i > 0; i--) {
			swap(a, i, 0);

			int index = 0;
			int greaterChild = getGreaterChild(a, index, i - 1);
			while (NULL_INDEX != greaterChild
					&& a[greaterChild].compareTo(a[index]) > 0) {
				swap(a, index, greaterChild);
				index = greaterChild;
				greaterChild = getGreaterChild(a, index, i - 1);
			}

		}
	}

	private static final int NULL_INDEX = -1;

	private static int getParent(final int index) {
		final int result = (index - 1) / 2;

		if (0 > result) {
			return NULL_INDEX;
		}

		return result;
	}

	private static int get1Child(final int index, final int boundary) {
		final int result = index * 2 + 1;
		if (boundary < result) {
			return NULL_INDEX;
		}

		return result;
	}

	private static int get2Child(final int index, final int boundary) {
		final int result = index * 2 + 2;
		if (boundary < result) {
			return NULL_INDEX;
		}

		return result;
	}

	private static <T extends Comparable<T>> int getGreaterChild(final T[] a,
			final int index, final int boundary) {
		final int c1 = get1Child(index, boundary);
		final int c2 = get2Child(index, boundary);

		if (NULL_INDEX == c1 && NULL_INDEX == c2) {
			return NULL_INDEX;
		}

		if (NULL_INDEX == c1) {
			return c2;
		}

		if (NULL_INDEX == c2) {
			return c1;
		}

		if (a[c1].compareTo(a[c2]) > 0) {
			return c1;
		} else {
			return c2;
		}
	}

	private static <T extends Comparable<T>> void swap(final T[] a,
			final int index, final int boundary) {
		final T tmp = a[index];
		a[index] = a[boundary];
		a[boundary] = tmp;
	}
}
