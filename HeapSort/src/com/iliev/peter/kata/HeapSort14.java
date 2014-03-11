package com.iliev.peter.kata;

import com.iliev.peter.kata.utils.Swapper;

public class HeapSort14 {

	private static int NULL_INDEX = -1;

	public static void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}

		// Build heap
		for (int i = 1; i < a.length; i++) {
			int ptr = i;
			int parent = getParentIndex(ptr);
			while (ptr != NULL_INDEX && a[parent].compareTo(a[ptr]) < 0) {
				Swapper.swap(a, ptr, parent);
				ptr = parent;
				parent = getParentIndex(ptr);
			}
		}

		// Sort heap
		for (int i = a.length - 1; i > 0; i--) {
			Swapper.swap(a, i, 0);

			int ptr = 0;
			int greaterChild = getGreaterChild(a, ptr, i - 1);
			while (greaterChild != NULL_INDEX && a[greaterChild].compareTo(a[ptr]) > 0) {
				Swapper.swap(a, ptr, greaterChild);
				ptr = greaterChild;
				greaterChild = getGreaterChild(a, ptr, i - 1);
			}
		}
	}

	private static int get1Child(final int index, final int boundary) {
		final int tmp = index * 2 + 1;

		if (tmp > boundary) {
			return NULL_INDEX;
		}

		return tmp;
	}

	private static int get2Child(final int index, final int boundary) {
		final int tmp = index * 2 + 2;

		if (tmp > boundary) {
			return NULL_INDEX;
		}

		return tmp;
	}

	private static int getParentIndex(final int index) {
		final int tmp = (index - 1) / 2;
		if (tmp < 0) {
			return NULL_INDEX;
		}

		return tmp;
	}

	private static int getGreaterChild(final Integer[] a, final int index, final int boundary) {
		final int c1 = get1Child(index, boundary);
		final int c2 = get2Child(index, boundary);

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
}
