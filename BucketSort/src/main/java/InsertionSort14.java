package com.peter.iliev.kata;

public class InsertionSort14 {

	public static void sort(final Integer[] a, final int from, final int toInc) {
		if (from >= toInc) {
			return;
		}

		for (int i = from + 1; i <= toInc; i++) {
			final int insetMe = a[i];
			int ptr = i - 1;
			while (ptr >= from && a[ptr].compareTo(insetMe) > 0) {
				a[ptr + 1] = a[ptr];
				ptr--;
			}
			a[ptr + 1] = insetMe;
		}
	}
}
