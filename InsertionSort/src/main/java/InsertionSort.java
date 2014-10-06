package main.java;

public final class InsertionSort {
	public static <T extends Comparable<T>> void sort(T[] a) {
		verify(a);
		
		if (!requiresSorting(a)) {
			return;
		}
		
		for (int i = 0; i < a.length; i++) {
			T lifted = a[i];
			int j = i - 1;
			while (j >= 0 && a[j].compareTo(lifted) > 0) {
				shift(a, j);
				j--;
			}
			
			a[j+1] = lifted;
		}
 	}
	
	private static <T extends Comparable<T>> void shift(T[] a, int index) {
		assert(a != null);
		assert(index >= 0);
		assert(index + 1 < a.length);
		
		a[index + 1] = a[index];
	}
	
	private static <T extends Comparable<T>> void verify(T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}
	}
	
	private static <T extends Comparable<T>> Boolean requiresSorting(T[] a) {
		assert(a != null);
		return a.length > 1;
	}	
}
