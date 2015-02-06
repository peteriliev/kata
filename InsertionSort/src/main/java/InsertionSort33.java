package main.java;

public class InsertionSort33 {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		for (int i = 1; i < a.length; i++) {
			int index = i - 1;
			final T insertMe = a[i];

			while (index >= 0 && a[index].compareTo(insertMe) > 0) {
				a[index + 1] = a[index];
				index--;
			}
			a[index + 1] = insertMe;
		}
	}
}
