package main.java;

import java.util.Arrays;

public class HS5 {

	private static final int NULL_INDEX = -1;

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length <= 1) {
			return;
		}

		// 1. build heap
		for (int i = 1; i < a.length; i++) {
			int index = i;
			int parent = getParentIndex(index);
			while (parent != NULL_INDEX && a[index].compareTo(a[parent]) > 0) {
				swap(a, index, parent);
				index = parent;
				parent = getParentIndex(index);
			}
		}
		
		System.out.println(String.format("Heap = %s", Arrays.toString(a)));
		
		// 2. sort heap
		for (int i = a.length - 1; i > 0; i--) {
			swap(a, i, 0);
			int index = 0;
			int greatChild = getGreateChildIndex(a, index, i - 1);
			while (greatChild != NULL_INDEX && a[index].compareTo(a[greatChild]) < 0) {
				swap(a, index, greatChild);
				index = greatChild;
				greatChild = getGreateChildIndex(a, index, i - 1);
			}
		}
	}
	
	private static <T extends Comparable<T>> int getGreateChildIndex(final T[] a, final int index, final int inclLimit) {
		final int c1 = get1ChildIndex(index, inclLimit);
		final int c2 = get2ChildIndex(index, inclLimit);
		
		if (c1 == NULL_INDEX && c2 == NULL_INDEX) {
			return NULL_INDEX;
		}
		
		if (c1 == NULL_INDEX) {
			return c2;
		}
		
		if (c2 == NULL_INDEX) {
			return c1;
		}
		
		if (a[c1].compareTo(a[c2]) > 0) {
			return c1;
		}
		
		return c2;
	}
	
	private static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
		final T tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
	
	private static int getParentIndex(final int index) {
		final int result = (index - 1) / 2;
		
		if (result < 0) {
			return NULL_INDEX;
		}
		
		return result;
	}
	
	private static int get1ChildIndex(final int index, final int limit) {
		final int result = index * 2 + 1;
		
		if (result > limit) {
			return NULL_INDEX;
		}
		
		return result;
	}
	
	private static int get2ChildIndex(final int index, final int limit) {
		final int result = get1ChildIndex(index, limit);
		
		if (result == NULL_INDEX) {
			return NULL_INDEX;
		}
		
		if (result + 1 > limit) {
			return NULL_INDEX;
		}
		
		return result + 1;
	}
}
