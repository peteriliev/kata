package com.peter.iliev.kata;

public class InsertionSort16 {

	public static void sort(final Integer[] a, final int s, final int eInc) {
		if (a.length < 2) {
			return;
		}

		for (int i = s + 1; i <= eInc; i++) {
			int pos = i;
			final Integer insertMe = a[pos];
			int index = pos - 1;
			while (index >= s && a[index].compareTo(insertMe) > 0) {
				a[index + 1] = a[index];
				index--;
			}

			a[index + 1] = insertMe;
		}
	}
}
