package main.java;

public class BubbleSort10 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length < 2) {
			return;
		}

		boolean swapped;
		for (int len = a.length; len > 0; len--) {
			swapped = false;
			for (int i = 0; i + 1 < len; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					swap(a, i, i + 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	public static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;

	}
}
