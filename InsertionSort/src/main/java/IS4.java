package main.java;

public class IS4 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		for (int i = 1; i < a.length; i++) {
			final T insertMe = a[i];
			int m = i - 1;

			while (m >= 0 && a[m].compareTo(insertMe) > 0) {
				a[m+1] = a[m];
				m--;
			}

			a[m + 1] = insertMe;
		}
	}
}
