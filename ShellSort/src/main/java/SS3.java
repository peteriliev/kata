package main.java;

public class SS3 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		final int[] gaps = { 701, 301, 132, 57, 23, 10, 4, 1 };
		
		for (final int gap : gaps) {
			
			for (int i = 0; i < gap; i++) {
				
				for (int j = i + gap; j < a.length; j+=gap) {
					
					final T insert = a[j];
					int m = j - gap;
					while (m >= i && a[m].compareTo(insert) > 0) {
						a[m+gap] = a[m];
						m -= gap;
					}
					
					a[m + gap] = insert;
				}
			}
		}
	}
}
