package com.peter.iliev.kata;

public class InsertionSort26 {

	public static void sort(final Integer[] a, final int start, final int end)
	{
		final int len = end - start + 1;
		if (len < 2) {
			return;
		}

		for (int i = start + 1; i <= end; i++) {
			final Integer insertMe = a[i];
			int ptr = i - 1;

			while (ptr >= start && a[ptr].compareTo(insertMe) > 0) {
				a[ptr + 1] = a[ptr];
				ptr--;
			}
			a[ptr + 1] = insertMe;
		}
	}
}
