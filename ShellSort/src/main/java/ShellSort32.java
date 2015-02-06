package main.java;

public class ShellSort32 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		final int[] gaps = { 701, 301, 132, 57, 23, 10, 4, 1 };

		for (final int gap : gaps) {
			for (int i = gap; i < a.length; i++) {
				final T insertMe = a[i];
				int index = i - gap;
				while (index >= 0 && a[index].compareTo(insertMe) > 0) {
					a[index + gap] = a[index];
					index -= gap;
				}
				a[index + gap] = insertMe;
			}
		}
	}
}
