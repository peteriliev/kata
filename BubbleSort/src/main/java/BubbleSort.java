package main.java;

public abstract class BubbleSort {
	private BubbleSort() {}
	
	public static <T extends Comparable<T>> void sort(T[] a) {
		if (a == null) {
			throw new IllegalArgumentException("Array is null");
		}
		
		if (!requiresSorting(a)) {
			return;
		}
		
		for (int i = a.length; i > 0; i--) {
			for (int j = 0; j + 1 < i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					bubble(a, j);
				}
			}
		}
	}
	
	private static <T extends Comparable<T>> void bubble(T[] a, int index) {
		assert(a != null);
		assert(!requiresSorting(a));
		assert(index > 0 && index < a.length);
		
		T tmp = a[index];
		a[index] = a[index + 1];
		a[index + 1] = tmp;
	}
	
	private static <T extends Comparable<T>> Boolean requiresSorting(T[] a) {
		assert(a != null);
		
		return a.length > 1;
	}
}
