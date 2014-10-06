package main.java;

import java.util.Arrays;

public class HS4 {

	private static final int EMPTY_INDEX = -1;

	public static <T extends Comparable<T>> void sort(final T[] a) {
		// 1. build heap
		orderHeap(a);
		
		System.out.println("Ordered heap = " + Arrays.toString(a));

		// 2. sort array
		sortArray(a);
	}
	
	private static <T extends Comparable<T>> void sortArray(final T[] a) {
		for (int i = a.length - 1; i > 0; i--) {
			swap(a, i, 0);
			orderTop(a, i - 1);
		}
	}
	
	private static <T extends Comparable<T>> void orderTop(final T[] a,
			final int end) {
		
		int tmp = 0;
		int greaterChild = getGreaterChild(a, tmp, end);
		
		while (greaterChild != EMPTY_INDEX && a[greaterChild].compareTo(a[tmp])> 0) {
			swap(a, tmp, greaterChild);
			tmp = greaterChild;
			greaterChild = getGreaterChild(a, tmp, end);
		}
		
	}
	
	private static <T extends Comparable<T>> int getGreaterChild(final T[] a,
			final int index, final int end) {
		
		final int c1 = getFirstChild(index, end);
		final int c2 = getSecondChild(index, end);
		
		if (c1 == EMPTY_INDEX && c2 == EMPTY_INDEX) {
			return EMPTY_INDEX;
		}
		
		if (c1 == EMPTY_INDEX) {
			return c2;
		}
		
		if (c2 == EMPTY_INDEX) {
			return c1;
		}
		
		if (a[c1].compareTo(a[c2]) > 0) {
			return c1;
		}
		
		return c2;
	}

	private static <T extends Comparable<T>> void orderHeap(final T[] a) {
		for (int i = 1; i < a.length; i++) {
			pushUp(a, i);
		}
	}

	private static <T extends Comparable<T>> void pushUp(final T[] a,
			final int index) {

		int tmp = index;
		int parentIndex = getParent(tmp);

		while (parentIndex != EMPTY_INDEX
				&& a[parentIndex].compareTo(a[tmp]) < 0) {
			swap(a, parentIndex, tmp);
			tmp = parentIndex;
			parentIndex = getParent(tmp);
		}
	}

	private static <T extends Comparable<T>> void swap(final T[] a,
			final int i, final int j) {
		final T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private static int getParent(final int i) {
		final int result = (i - 1) / 2;

		if (result < 0) {
			return EMPTY_INDEX;
		}

		return result;
	}

	private static int getFirstChild(final int i, final int end) {
		final int result = i * 2 + 1;
		if (result > end) {
			return EMPTY_INDEX;
		}

		return result;
	}

	private static int getSecondChild(final int i, final int end) {
		final int firstChilc = getFirstChild(i, end);
		if (firstChilc > end) {
			return EMPTY_INDEX;
		}

		final int result = firstChilc + 1;
		if (result > end) {
			return EMPTY_INDEX;
		}

		return result;
	}

}
