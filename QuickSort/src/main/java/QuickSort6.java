package main.java;

public class QuickSort6 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length <= 1) {
			return;
		}
		
		sortInternal(a, 0, a.length - 1);
	}

	public static <T extends Comparable<T>> void sortInternal(final T[] a, final int from, final int to) {
		if (from >= to) {
			return;
		}
		
		int left = from;
		int right = to;
		int pivot = left;
		final T pivotValue = a[pivot];
		
		while (left < right) {
			while (right > left && a[right].compareTo(pivotValue) >= 0) {
				right--;
			}
			
			if (right > left) {
				swap(a, right, pivot);
				pivot = right;
				left++;
			}
			
			while (left < right && a[left].compareTo(pivotValue) <= 0) {
				left++;
			}
			
			if (left < right) {
				swap(a, left, pivot);
				pivot = left;
				right--;
			}
		}
		
		sortInternal(a, from, pivot - 1);
		sortInternal(a, pivot + 1, to);
	}
	
	private static <T extends Comparable<T>> void swap(final T[] a, final int from, final int to) {
		final T tmp = a[from];
		a[from] = a[to];
		a[to] = tmp;
	}
	
}
