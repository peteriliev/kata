package com.iliev.peter.kata;

import java.util.Arrays;

public class HeapSort8 {

	private final static int NULL_INDEX = -1;

	public static void sort(final Integer[] a) {
		if (1 >= a.length) {
			return;
		}
		
		for (int i = 1; i < a.length; i++) {
			int parent = getParentIndex(i);
			int ptr = i;
			while (NULL_INDEX != parent && a[ptr].compareTo(a[parent]) > 0) {
				swap(a, ptr, parent);
				ptr = parent;
				parent = getParentIndex(ptr);
			}
		}
		
		System.out.println("Heaped = " + Arrays.toString(a));
		
		for (int i = a.length -1; i > 0; i--) {
			swap(a, i, 0);
			int ptr = 0;
			int greatChild = getGreaterChile(a, ptr, i - 1);
			
			while (NULL_INDEX != greatChild && a[ptr].compareTo(a[greatChild]) < 0) {
				swap(a, ptr, greatChild);
				ptr = greatChild;
				greatChild = getGreaterChile(a, ptr, i - 1);
			}
		}

	}
	
	

	private static final int getParentIndex(final int index) {

		if (0 >= index) {
			return NULL_INDEX;
		}

		return (index - 1) / 2;
	}

	private static final int get1ChildIndex(final int index, final int boundaryInc) {
		final int result = index * 2 + 1;
		if (result > boundaryInc) {
			return NULL_INDEX;
		}
		return result;

	}

	private static final int get2ChildIndex(final int index, final int boundaryInc) {
		final int result = get1ChildIndex(index, boundaryInc);
		if (NULL_INDEX == result) {
			return NULL_INDEX;
		}
		
		if (result + 1 > boundaryInc) {
			return NULL_INDEX;
		}
		
		return result + 1;
	
	
	}
	
	private static final void swap(final Integer[] a, final int index, final int boundaryInc) {
		final Integer tmp = a[index];
		a[index] = a[boundaryInc];
		a[boundaryInc] = tmp;
	}
	
	private static final int getGreaterChile(final Integer[] a, final int index, final int boundaryInc) {
		final int c1 = get1ChildIndex(index, boundaryInc);
		final int c2 = get2ChildIndex(index, boundaryInc);
		if (NULL_INDEX == c1 && NULL_INDEX == c2) {
			return NULL_INDEX;
		}
		
		if (NULL_INDEX == c1) {
			return c2;
		}
		
		if (NULL_INDEX == c2) {
			return c1;
		}
		
		if (a[c1].compareTo(a[c2]) > 0) {
			return c1;
		} else {
			return c2;
		}
	}
}
