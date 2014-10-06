package main.java;

public class SelectionSort9 {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		for (int i = 0; i < a.length - 1; i++) {
			int min = i;

			for (int j = i + 1; j < a.length; j++) {
				if (a[j].compareTo(a[min]) < 0) {
					min = j;
				}
			}

			if (i != min) {
				final T tmp = a[min];
				a[min] = a[i];
				a[i] = tmp;
			}
		}

	}
}
