package main.java;

public class SS4 {
	public static <T extends Comparable<T>> void sort(final T[] a) {

		final int[] gaps = { 701, 301, 132, 57, 23, 10, 4, 1 };

		for (final int gap : gaps) {
			if (gap >= a.length) {
				continue;
			}

			for (int i = 0; i < gap; i++) {

				for (int j = i + gap; j < a.length; j += gap) {

					final T insertMe = a[j];
					int index = j - gap;
					while (index >= i && a[index].compareTo(insertMe) > 0) {
						a[index + gap] = a[index];
						index -= gap;
					}
					a[index + gap] = insertMe;
				}
			}
		}
	}
}
