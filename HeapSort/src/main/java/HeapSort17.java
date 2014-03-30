package com.iliev.peter.kata;

import java.util.Arrays;
import java.util.Collections;

public class HeapSort17 {

	private static final int NULL_PTR = -1;

	public static <T extends Comparable<T>> void sort(final T[] a) {

		for (int i = 1; i < a.length; i++) {
			int ptr = i;
			int parent = getParent(ptr);
			while (NULL_PTR != parent && a[parent].compareTo(a[ptr]) < 0) {
				Collections.swap(Arrays.asList(a), ptr, parent);
				ptr = parent;
				parent = getParent(ptr);
			}
		}

		System.out.println(String.format("Heap = %s", (Arrays.toString(a))));

		for (int i = a.length - 1; i > 0; i--) {// ?
			Collections.swap(Arrays.asList(a), i, 0);

			int ptr = 0;
			int greaterChild = getGreaterChild(a, ptr, i - 1);
			while (NULL_PTR != greaterChild && a[greaterChild].compareTo(a[ptr]) > 0) {
				Collections.swap(Arrays.asList(a), ptr, greaterChild);
				ptr = greaterChild;
				greaterChild = getGreaterChild(a, ptr, i - 1);
			}
		}
	}

	private static int get1Child(final int index, final int boundary) {
		final int tmp = index * 2 + 1;

		if (tmp > boundary) {
			return NULL_PTR;
		}

		return tmp;
	}

	private static int get2Child(final int index, final int boundary) {
		final int tmp = index * 2 + 2;

		if (tmp > boundary) {
			return NULL_PTR;
		}

		return tmp;
	}

	private static int getParent(final int index) {
		final int tmp = (index - 1) / 2;

		if (tmp < 0) {
			return NULL_PTR;
		}

		return tmp;
	}

	private static <T extends Comparable<T>> int getGreaterChild(final T[] a, final int index, final int boundary) {
		final int c1 = get1Child(index, boundary);
		final int c2 = get2Child(index, boundary);

		if (c1 == NULL_PTR && c2 == NULL_PTR) {
			return NULL_PTR;
		}

		if (c1 == NULL_PTR) {
			return c2;
		}

		if (c2 == NULL_PTR) {
			return c1;
		}

		if (a[c1].compareTo(a[c2]) > 0) {
			return c1;
		} else {
			return c2;
		}
	}
}