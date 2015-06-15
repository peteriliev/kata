package main.java;

public class InsertionSort39 {

	public static void sort(final Integer[] a, final int start, final int end) {
		for (int i = start + 1; i <= end; i++) {
			final int insertMe = a[i];
			int index = i - 1;
			while (index >= start && a[index].compareTo(insertMe) > 0) {
				a[index + 1] = a[index];
				index--;
			}
			a[index + 1] = insertMe;
		}
	}
}
