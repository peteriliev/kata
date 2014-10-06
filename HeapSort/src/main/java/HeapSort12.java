package main.java;

public class HeapSort12 {

    private static final int EMPTY_INDEX = -1;

    public static <T extends Comparable<T>> void sort(final T[] a) {
	if (1 >= a.length) {
	    return;
	}

	// 1. Build heap
	for (int i = 1; i < a.length; i++) {

	    int ptr = i;
	    int parent = getParent(ptr);

	    while (parent != EMPTY_INDEX && a[parent].compareTo(a[ptr]) < 0) {
		swap(a, ptr, parent);
		ptr = parent;
		parent = getParent(ptr);
	    }
	}

	// 2. Sort
	for (int i = a.length - 1; i > 0; i--) {
	    swap(a, i, 0);

	    int ptr = 0;
	    int greaterChild = getGreaterChild(a, ptr, i - 1);

	    while (greaterChild != EMPTY_INDEX && a[greaterChild].compareTo(a[ptr]) > 0) {
		swap(a, ptr, greaterChild);
		ptr = greaterChild;
		greaterChild = getGreaterChild(a, ptr, i - 1);

	    }
	}
    }

    private static int get1Child(final int index, final int boundaryInc) {
	final int result = index * 2 + 1;
	if (result > boundaryInc) {
	    return EMPTY_INDEX;
	}
	return result;
    }

    private static int get2Child(final int index, final int boundaryInc) {
	final int result = index * 2 + 2;
	if (result > boundaryInc) {
	    return EMPTY_INDEX;
	}
	return result;
    }

    private static int getParent(final int index) {
	final int result = (index - 1) / 2;
	if (result < 0) {
	    return EMPTY_INDEX;
	}
	return result;
    }

    private static <T extends Comparable<T>> int getGreaterChild(final T[] a, final int index, final int boundaryInc) {
	final int c1 = get1Child(index, boundaryInc);
	final int c2 = get2Child(index, boundaryInc);
	if (EMPTY_INDEX == c1 && EMPTY_INDEX == c2) {
	    return EMPTY_INDEX;
	}

	if (EMPTY_INDEX == c1) {
	    return c2;
	}

	if (EMPTY_INDEX == c2) {
	    return c1;
	}

	if (a[c1].compareTo(a[c2]) > 0) {
	    return c1;
	} else {
	    return c2;
	}

    }

    private static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
	final T tmp = a[x];
	a[x] = a[y];
	a[y] = tmp;
    }

}
