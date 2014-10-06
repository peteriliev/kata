package main.java;

import com.iliev.peter.kata.utils.Swapper;

public class CombSort16 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		if (a.length < 2) {
			return;
		}

		int gap = a.length;
		boolean swapped = true;

		while (swapped || gap > 1) {
			gap = (int) (gap / 1.3);
			if (gap < 1) {
				gap = 1;
			}
			swapped = false;

			for (int j = a.length; j >= gap; j -= gap) {
				for (int i = 0; i + gap < j; i += gap) {
					if (a[i].compareTo(a[i + gap]) > 0) {
						Swapper.swap(a, i, i + gap);
						swapped = true;
					}
				}
			}
		}
	}
}
