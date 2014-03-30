package com.peter.iliev.kata;

public class InsertionSort25 {

	public static void sort(final Integer[] a, final int s, final int e)
	{
		for (int i = s + 1; i <= e; i++) {
			final Integer insertMe = a[i];
			int ptr = i - 1;
			while (ptr >= s && a[ptr].compareTo(insertMe) > 0) {
				a[ptr + 1] = a[ptr];
				ptr--;
			}
			a[ptr + 1] = insertMe;
		}
	}
}
