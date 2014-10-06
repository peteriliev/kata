package main.java;

import java.util.Arrays;

public class HS2 {

	private static final int NULL_INDEX = -1;

	public static <T extends Comparable<T>> void sort(final T[] a) {

		// 1. Sort heap
		for (int i = 0; i < a.length; i++) {
			pushUp(a, i);
		}
		System.out.println("Sorted heap = " + Arrays.toString(a));

		// 2. Sort array
		for (int j = a.length - 1; j > 0; j--) {
			swap(a, j, 0);
			pushDown(a, j - 1);
		}
	}

	private static int getParentIndex(final int index, final int end) {
		final int parent = (index - 1) / 2;

		if (parent < 0) {
			return NULL_INDEX;
		}

		return parent;
	}

	private static int getChild1Index(final int index, final int end) {
		final int c1 = index * 2 + 1;

		if (c1 < 0 || c1 > end) {
			return NULL_INDEX;
		}

		return c1;
	}

	private static int getChild2Index(final int index, final int end) {
		final int c1 = getChild1Index(index, end);

		if (c1 == NULL_INDEX) {
			return NULL_INDEX;
		}

		if (c1 + 1 < 0 || c1 + 1 > end) {
			return NULL_INDEX;
		}

		return c1 + 1;
	}

	private static <T extends Comparable<T>> void pushUp(final T[] a,
			final int end) {
		if (a.length == 0) {
			return;
		}

		int x = end;

		int xParent = getParentIndex(x, end);
		while (xParent != NULL_INDEX && a[x].compareTo(a[xParent]) > 0) {
			swap(a, x, xParent);
			x = xParent;
			xParent = getParentIndex(x, end);
		}
	}

	private static <T extends Comparable<T>> void pushDown(final T[] a,
			final int end) {
		if (a.length == 0) {
			return;
		}

		int x = 0;
		int biggerChild = getBiggerChild(a, x, end);

		while (biggerChild != NULL_INDEX && a[x].compareTo(a[biggerChild]) < 0) {
			swap(a, x, biggerChild);
			x = biggerChild;
			biggerChild = getBiggerChild(a, x, end);
		}
	}

	private static <T extends Comparable<T>> int getBiggerChild(final T[] a,
			final int x, final int end) {
		int c1 = getChild1Index(x, end);
		int c2 = getChild2Index(x, end);

		if (c1 == NULL_INDEX && c2 == NULL_INDEX) {
			return NULL_INDEX;
		}

		if (c1 == NULL_INDEX) {
			return c2;
		}

		if (c2 == NULL_INDEX) {
			return c1;
		}

		if (a[c1].compareTo(a[c2]) > 0) {
			return c1;
		} else {
			return c2;
		}
	}

	private static <T extends Comparable<T>> void swap(final T[] a,
			final int x, final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
