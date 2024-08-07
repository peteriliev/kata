package main.java;

public class ShellSort23 {

	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		final int[] gaps = { 701, 301, 132, 57, 23, 10, 4, 1 };

		for (final int gap : gaps) {
			for (int i = gap; i < a.length; i++) {
				int ptr = i - gap;
				final T insertMe = a[i];
				while (ptr >= 0 && a[ptr].compareTo(insertMe) > 0) {
					a[ptr + gap] = a[ptr];
					ptr -= gap;
				}
				a[ptr + gap] = insertMe;

			}
		}
	}
}
