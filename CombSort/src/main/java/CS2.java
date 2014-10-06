package main.java;

public class CS2 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		
		
		int gap = a.length;
		boolean swapped = true;
		
		while (swapped || gap > 1) {
			
			gap = (int) (gap / 1.3);
			if (gap < 1) {
				gap = 1;
			}
			
			swapped = false;
			
			for (int j = a.length; j > 0; j -= gap) {

				for (int i = 0; i + gap < j; i+=gap) {
					if (a[i].compareTo(a[i+gap]) > 0) {
						final T tmp = a[i];
						a[i] = a[i+gap];
						a[i+gap] = tmp;
						swapped = true;
					}
				}
			}
		}
	}
}
