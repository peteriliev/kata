package com.iliev.peter.kata;

import com.iliev.peter.kata.utils.Swapper;

public class StoogeSort3 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length < 2) {
			return;
		}

		sortInternal(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int end) {
		final int len = end - start + 1;
		if (len < 2) {
			return;
		}

		if (a[start].compareTo(a[end]) > 0) {
			Swapper.swap(a, start, end);
		}

		if (len < 3) {
			return;
		}
		final int aThird = len / 3;
		sortInternal(a, start, end - aThird);
		sortInternal(a, start + aThird, end);
		sortInternal(a, start, end - aThird);
	}
}
