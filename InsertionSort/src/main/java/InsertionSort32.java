package main.java;

public class InsertionSort32 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		final int last = a.length - 1;

		for (int i = last - 1; i >= 0; i--) {
			final T insertMe = a[i];
			int index = i + 1;

			while (index <= last && a[index].compareTo(insertMe) < 0) {
				a[index - 1] = a[index];
				index++;
			}
			a[index - 1] = insertMe;
		}
	}
}
