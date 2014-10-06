package main.java;

public class CombSort10 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length < 2) {
			return;
		}

		int gap = a.length;

		boolean swapped = true;
		while (gap > 1 || swapped) {
			swapped = false;
			gap = (int) (gap / 1.3);
			if (gap < 1) {
				gap = 1;
			}

			for (int i = 0; i + gap < a.length; i++) {
				if (a[i].compareTo(a[i + gap]) > 0) {
					swap(a, i, i + gap);
					swapped = true;
				}
			}
		}
	}

	public static <T extends Comparable<T>> void swap(final T[] a, final int x,
			final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;

	}
}
