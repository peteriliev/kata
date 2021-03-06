package com.peter.iliev.kata;

public class Insert3 {
	public static void sort(final Integer[] a, final int start, final int end) {
		
		for (int i = start + 1; i <= end; i++) {
			final int insertMe = a[i];
			int ptr = i - 1;
			while (ptr >= start && a[ptr].compareTo(insertMe) > 0) {
				a[ptr + 1] = a[ptr];
				ptr--;
			}
			
			a[ptr + 1] = insertMe;
		}
	}
}
