package main.java;

public class SS2 {

	public static <T extends Comparable<T>> void sort(T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		if (!requiresSorting(a)) {
			return;
		}
		
		for (int i = 0; i < a.length; i++) {
			T minElement = a[i];
			int minIndex = i;
			for (int j = i; j < a.length; j++) {
				if (minElement.compareTo(a[j]) > 0) {
					minElement = a[j];
					minIndex = j;
				}
			}
			
			swap(a, i, minIndex);
		}
	}
	
	private static <T extends Comparable<T>> Boolean requiresSorting(T[] a) {
		return a.length > 1;
	}

	private static <T extends Comparable<T>> void swap(T[] a, int i, int j) {
		if (i == j) {
			return;
		}
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
