package main.java;

public class BubbleSort5 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		boolean swapped = true;
		for (int i = a.length; i > 0 && swapped; i--) {
			swapped = false;
			for (int j = 0; j + 1 < i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					final T tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					swapped = true;
				}
			}
		}
	}
}
