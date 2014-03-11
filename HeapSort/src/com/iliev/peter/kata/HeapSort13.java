package com.iliev.peter.kata;

public class HeapSort13 {
    public static <T extends Comparable<T>> void sort(final T[] a) {
	if (a.length < 2) {
	    return;
	}

	// 1. Build heap
	for (int i = 1; i < a.length; i++) {
	    int index = i;
	    int parent = getParent(index);

	    while (parent != NULL_INDEX && a[parent].compareTo(a[index]) < 0) {
		swap(a, parent, index);
		index = parent;
		parent = getParent(index);
	    }
	}

	// 2. Sort heap
	for (int i = a.length - 1; i > 0; i--) {
	    swap(a, i, 0);
	    int index = 0;
	    int greaterChild = getGreaterChild(a, index, i - 1);
	    while (greaterChild != NULL_INDEX && a[index].compareTo(a[greaterChild]) < 0) {
		swap(a, index, greaterChild);
		index = greaterChild;
		greaterChild = getGreaterChild(a, index, i - 1);

	    }
	}
    }

    private static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
	final T tmp = a[x];
	a[x] = a[y];
	a[y] = tmp;

    }

    private static final int NULL_INDEX = -1;

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

    private static int getParent(final int index) {
	final int tmp = (index - 1) / 2;
	if (tmp < 0) {
	    return NULL_INDEX;
	}

	return tmp;
    }

    private static <T extends Comparable<T>> int getGreaterChild(final T[] a, final int index, final int boundary) {
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
