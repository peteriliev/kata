package com.iliev.peter.kata;

public class ShellSort {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		final int[] gaps = { 701, 301, 132, 57, 23, 10, 4, 1 };

		for (final int gap : gaps) {

			for (int i = 0; i + gap < a.length; i++) {

				for (int j = i + gap; j < a.length; j += gap) {
					final T lifted = a[j];
					int z = j - gap;
					while (z >= i && a[z].compareTo(lifted) > 0) {
						shiftLeft(a, z, gap);
						z -= gap;
					}

					a[z + gap] = lifted;
				}
			}
		}
	}

	private static <T extends Comparable<T>> void shiftLeft(final T[] a,
			final int index, final int gap) {
		a[index + gap] = a[index];
	}
}
