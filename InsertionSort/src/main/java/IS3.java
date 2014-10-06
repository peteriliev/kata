package main.java;

public class IS3 {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 1; i < a.length; i++) {
			T lifted = a[i];
			int j = i-1;
			while (j >= 0 && a[j].compareTo(lifted) > 0) {
				shiftRight(a, j);
				j--;
			}
			
			a[j+1] = lifted;
			
		}
	}
	
	public static <T extends Comparable<T>> void shiftRight(final T[] a, final int i) {
		a[i + 1] = a[i];
	}
}
