package com.peter.iliev.kata;

public class InsertionSort4 {

	public static void sort(final Integer[] a, final int start, final int iInc) {
		
		for (int i = start + 1; i <= iInc; i++) {
			final Integer insertMe = a[i];
			int ptr = i - 1;
			while (ptr >= start && a[ptr] > insertMe) {
				a[ptr + 1] = a[ptr];
				ptr--;
			}
			a[ptr + 1] = insertMe;
		}
	}
}
