package com.iliev.peter.kata;

import java.util.Arrays;

public class HeapSort6 {

	private static final int NULL_INDEX = -1;

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		if (a.length <= 1) {
			return;
		}

		// 1. Build heap
		for (int i = 1; i < a.length; i++) {
			int parent = getParent(i);
			while (parent != NULL_INDEX && a[i].compareTo(a[parent]) > 0) {
				swap(a, i, parent);
				i = parent;
				parent = getParent(i);
			}
		}

		System.out
				.println(String.format("Sorted heap = %s", Arrays.toString(a)));

		// 2. Sort heap
		for (int i = a.length - 1; i > 0; i--) {
			swap(a, i, 0);

			int ptr = 0;
			int greaterChild = getGreaterChild(a, ptr, i - 1);

			while (greaterChild != NULL_INDEX
					&& a[greaterChild].compareTo(a[ptr]) > 0) {
				swap(a, ptr, greaterChild);
				ptr = greaterChild;
				greaterChild = getGreaterChild(a, ptr, i - 1);
			}
		}
	}

	private static <T extends Comparable<T>> int getGreaterChild(final T[] a,
			final int index, int limitInc) {
		final int c1 = get1Child(index, limitInc);
		final int c2 = get2Child(index, limitInc);

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
			final int i, final int x) {
		final T tmp = a[i];
		a[i] = a[x];
		a[x] = tmp;
	}

	private static <T extends Comparable<T>> int getParent(final int index) {
		final int result = (index - 1) / 2;
		if (result < 0) {
			return NULL_INDEX;
		}

		return result;
	}

	private static <T extends Comparable<T>> int get1Child(final int index,
			int limitInc) {
		final int result = index * 2 + 1;
		if (result > limitInc) {
			return NULL_INDEX;
		}

		return result;
	}

	private static <T extends Comparable<T>> int get2Child(final int index,
			int limitInc) {
		final int child1 = get1Child(index, limitInc);
		if (child1 == NULL_INDEX) {
			return NULL_INDEX;
		}

		final int result = child1 + 1;
		if (result > limitInc) {
			return NULL_INDEX;
		}

		return result;
	}

}
