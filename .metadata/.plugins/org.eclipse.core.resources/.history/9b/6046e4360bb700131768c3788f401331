package com.iliev.peter.kata;

public class StoogeSort {

    public static <T extends Comparable<T>> void sort(final T[] a) {
	if (a.length < 2) {
	    return;
	}

	sortInternal(a, 0, a.length - 1);
    }

    private static <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int end) {
	final int len = end - start + 1;
	if (len < 2) {
	    return;
	}
	
	if (a[start].compareTo(a[end]) > 0) {
	    swap(a, start, end);
	}
	
	if (len < 3) {
	    return;
	}
	final int aThird = len / 3;
	sortInternal(a, start, end - aThird);
	sortInternal(a, start + aThird, end);
	sortInternal(a, start, end - aThird);
    }

    private static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
	final T tmp = a[x];
	a[x] = a[y];
	a[y] = tmp;
    }
}
