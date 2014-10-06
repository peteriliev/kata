package main.java;


public final class SelectionSort {
	private SelectionSort() {
	}

	public static <T extends Comparable<T>> void sort(T[] a) {
		verifyArgs(a);
		
		if (!requiresSorting(a)) {
			return;
		}
		
		for (int i = 0; i < a.length; i++) {
			int minIndex = i;
			for (int j = i; j < a.length; j++) {
				if (a[minIndex].compareTo(a[j]) > 0) {
					minIndex = j;
				}
			}
			swap(a, i, minIndex);
		}
	}
	
	private static <T extends Comparable<T>> void swap(T[] a, int index1, int index2) {
		if (index1 == index2) {
			return;
		}
		T tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}
	
	private static <T extends Comparable<T>> void verifyArgs(T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}
	}
	
	private static <T extends Comparable<T>> Boolean requiresSorting(T[] a) {
		assert(a != null);
		
		return a.length > 1;
	}
}
