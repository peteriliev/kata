package com.iliev.peter.kata;

public class ShellSort10 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length < 2) {
			return;
		}

		final int[] gaps = { 701, 301, 132, 57, 23, 10, 4, 1 };

		for (final int gap : gaps) {
			for (int i = gap; i < a.length; i++) {
				final T insertMe = a[i];
				int ptr = i - gap;
				while (ptr >= 0 && a[ptr].compareTo(insertMe) > 0) {
					a[ptr + gap] = a[ptr];
					ptr = ptr - gap;
				}
				a[gap + ptr] = insertMe;
			}
		}
	}

	public static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;

	}
}
