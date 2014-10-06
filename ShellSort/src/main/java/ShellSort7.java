package main.java;

public class ShellSort7 {
    public static <T extends Comparable<T>> void sort(final T[] a) {
	if (a.length <= 1) {
	    return;
	}

	final int[] gaps = { 701, 301, 132, 57, 23, 10, 4, 1 };

	for (final int gap : gaps) {
	    for (int i = gap; i < a.length; i++) {
		final T liftMe = a[i];
		int ptr = i - gap;
		while (ptr >= 0 && a[ptr].compareTo(liftMe) > 0) {
		    a[ptr + gap] = a[ptr];
		    ptr -= gap;
		}
		a[ptr + gap] = liftMe;
	    }
	}
    }

    public static <T extends Comparable<T>> void swap(final T[] a, final int i, final int y) {
	final T tmp = a[i];
	a[i] = a[y];
	a[y] = tmp;
    }
}
