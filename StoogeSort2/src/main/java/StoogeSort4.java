package main.java;

import com.iliev.peter.kata.utils.Swapper;

public class StoogeSort4 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a, final int from, final int to) {

		final int len = to - from + 1;
		if (len < 2) {
			return;
		}

		if (a[from].compareTo(a[to]) > 0) {
			Swapper.swap(a, from, to);
		}

		if (len < 3) {
			return;
		}

		final int aThird = len / 3;
		sortInternal(a, from, to - aThird);
		sortInternal(a, from + aThird, to);
		sortInternal(a, from, to - aThird);
	}
}
