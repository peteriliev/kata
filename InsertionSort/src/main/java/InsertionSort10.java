package main.java;

public class InsertionSort10 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length < 2) {
			return;
		}

		for (int i = 1; i < a.length; i++) {
			final T insertMe = a[i];
			int ptr = i - 1;
			while (ptr >= 0 && a[ptr].compareTo(insertMe) > 0) {
				a[ptr + 1] = a[ptr];
				ptr--;
			}
			a[ptr + 1] = insertMe;
		}
	}
}
