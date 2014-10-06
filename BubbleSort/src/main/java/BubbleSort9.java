package main.java;

public class BubbleSort9 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (1 >= a.length) {
			return;
		}

		for (int i = a.length; i > 0; i--) {
			boolean swapped = false;
			for (int j = 0; j + 1 < i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					final T tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					swapped = true;
				}
			}
			
			if (!swapped) {
				break;
			}
		}
	}
}
