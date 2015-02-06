package main.java;

import java.util.Arrays;
import java.util.Collections;

public class CombSort32 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		boolean swapped = false;
		int gap = a.length;

		while (gap > 1 || swapped) {
			gap = (int) (gap / 1.3);
			if (gap < 1) {
				gap = 1;
			}

			swapped = false;
			for (int i = 0; i + gap < a.length; i++) {
				if (a[i + gap].compareTo(a[i]) < 0) {
					swapped = true;
					Collections.swap(Arrays.asList(a), i, i + gap);
				}
			}

			if (!swapped) {
				break;
			}
		}
	}
}
