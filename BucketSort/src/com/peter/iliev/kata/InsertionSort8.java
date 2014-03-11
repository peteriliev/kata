package com.peter.iliev.kata;

public class InsertionSort8 {

	public static void sort(final Integer[] a, final int from, final int toInc) {

		for (int i = from + 1; i <= toInc; i++) {
			final int insertMe = a[i];
			int ptr = i - 1;

			while (ptr >= from && a[ptr] > insertMe) {
				a[ptr + 1] = a[ptr];
				ptr--;
			}

			a[ptr + 1] = insertMe;
		}
	}
}
