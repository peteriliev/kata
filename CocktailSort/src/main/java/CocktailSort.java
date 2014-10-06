package main.java;

public final class CocktailSort {
	public static <T extends Comparable<T>> void sort(T[] a) {
		if (!requiresSorting(a)) {
			return;
		}
		
		int start = 0;
		int end = a.length - 1;
		Boolean swapped = true;
		
		while(swapped) {
			swapped = false;
			for(int i = start; i < end; i++) {
				if (a[i].compareTo(a[i+1]) > 0) {
					swap(a, i);
					swapped = true;
				}
			}
			end--;
			
			if (!swapped) {
				break;
			}
			
			for(int j = end; j > start; j--) {
				if (a[j].compareTo(a[j-1]) < 0) {
					swap(a, j-1);
					swapped = true;
				}
			}
			start++;
		}
		
	}
	
	private static <T extends Comparable<T>> void swap(T[] a, int index) {
		T tmp = a[index];
		a[index] = a[index + 1];
		a[index + 1] = tmp;
	}
	
	public static <T extends Comparable<T>> Boolean requiresSorting(T[] a) {
		return a.length > 1;
	}


}
