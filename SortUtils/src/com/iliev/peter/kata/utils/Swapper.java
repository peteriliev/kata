package com.iliev.peter.kata.utils;

public class Swapper {
	public static <T extends Comparable<T>> void swap(final T[] a,
			final int i, final int j) {

		if (a == null) {
			throw new IllegalArgumentException();
		}

		if (!isInRange(a, i)) {
			throw new ArrayIndexOutOfBoundsException(i);
		}

		if (!isInRange(a, j)) {
			throw new ArrayIndexOutOfBoundsException(j);
		}
		
		if (i == j) {
			return;
		}

		final T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static <T extends Comparable<T>> boolean isInRange(final T[] a,
			final int i) {
		if (i < 0) {
			return false;
		}

		if (i >= a.length) {
			return false;
		}

		return true;
	}
}
