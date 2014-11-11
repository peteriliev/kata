package main.java;

public class InsertionSort31 {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		for (int i = 1; i < a.length; i++) {
			final T insertMe = a[i];
			int index = i - 1;

			while (index >= 0 && a[index].compareTo(insertMe) > 0) {
				a[index + 1] = a[index];
				index--;
			}
			a[index + 1] = insertMe;
		}

	}
}
