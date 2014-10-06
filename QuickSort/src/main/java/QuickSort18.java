package main.java;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class QuickSort18 {
	public static final <T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	private static final <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int end) {
		if (!(end > start)) {
			return;
		}
		
		int left = start;
		int right = end;
		int pivot = left;
		final T pivoitVal = a[pivot];
		
		
		while (left < right) {
			while (right > left && a[right].compareTo(pivoitVal) >= 0) {
				right--;
			}
			
			if (right > left) {
				Collections.swap(Arrays.asList(a), right, pivot);
				pivot = right;
				left++;   
			}
			
			while (left < right && a[left].compareTo(pivoitVal) <= 0) {
				left++;
			}
			
			if (left < right) {
				Collections.swap(Arrays.asList(a), left, pivot) ;
				pivot = left;
				right--;
			}
		}
		
		sortInternal(a, start, pivot - 1);
		sortInternal(a, pivot + 1, end);
	}
}
