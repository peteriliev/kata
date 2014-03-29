package com.iliev.peter.kata;

import java.util.Arrays;
import java.util.Collections;

public class StoogeSort25 {

	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		sortInternal(a, 0, a.length - 1);
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a, final int s, final int e)
	{
		final int len = e - s + 1;
		if (len < 2) {
			return;
		}
		
		if (a[s].compareTo(a[e]) > 0) {
			Collections.swap(Arrays.asList(a), s, e);
		}
		
		if (len < 3) {
			return;
		}
		
		final int aThird = len / 3;
		
		sortInternal(a, s, e - aThird);
		sortInternal(a, s + aThird, e);
		sortInternal(a, s, e - aThird);
	}
}
