package main.java;

public class IS2 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		int left = 0;
		int right = a.length;
		
		
		while (left < right) {
			boolean swapped = false;
			
			for (int i = left; i + 1 < right; i++) {
				if (a[i].compareTo(a[i+1]) > 0) {
					final T tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}

			right--;
			
			
			swapped = false;
			for (int j = right; j - 1 >= left; j--) {
				if (a[j].compareTo(a[ j - 1]) < 0) {
					final T tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
					swapped = true;
				}
			}

			if (!swapped) {
				break;
			}
			
			left++;
		}
	}
}
