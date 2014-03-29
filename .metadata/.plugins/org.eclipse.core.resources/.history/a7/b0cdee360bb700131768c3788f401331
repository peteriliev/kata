package com.iliev.peter.kata;

import com.iliev.peter.kata.utils.Swapper;

public class StoogeSort2 {

	public static <T extends Comparable<T>> void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}
		
		sortInternsl(a, 0, a.length - 1);
	}

	public static <T extends Comparable<T>> void sortInternsl(final Integer[] a, final int from, final int toInc) {
		final int len = toInc - from + 1;
		if (len < 2) {
			return;
		}

		if (a[from].compareTo(a[toInc]) > 0) {
			Swapper.swap(a, from, toInc);
		}

		if (len < 3) {
			return;
		}

		final int aThird = len / 3;
		sortInternsl(a, from, toInc - aThird);
		sortInternsl(a, from + aThird, toInc);
		sortInternsl(a, from, toInc - aThird);

	}
}
