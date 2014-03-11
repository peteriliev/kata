package com.iliev.peter.kata;

public class InsertionSort26 {
	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		for (int i = 1; i < a.length; i++) {
			final T insertMe = a[i];
			int ptr = i - 1;
			while (ptr >= 0 && a[ptr].compareTo(insertMe) > 0) {
				a[ptr + 1] = a[ptr];
				ptr--;
			}
			a[ptr + 1] = insertMe;
		}
	}
}
