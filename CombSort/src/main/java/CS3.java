package main.java;

public class CS3 {
	public static <T extends Comparable<T>> void sort(final T[] a) {
		
		
		int gap = a.length;
		boolean swapped = false;
		
		while (gap > 1 || swapped) {
			swapped = false;
			gap = (int) (gap / 1.27);
			if (gap < 1) {
				gap = 1;
			}
			
			for (int i = 0; i + gap < a.length; i+= gap) {
				if (a[i].compareTo(a[i+gap]) > 0) {
					final T tmp = a[i];
					a[i] = a[i + gap];
					a[i + gap] = tmp;
					swapped = true;
				}
			}
		}
	}
}
