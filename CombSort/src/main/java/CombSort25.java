package main.java;

import java.util.Arrays;
import java.util.Collections;

public class CombSort25 {

	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		int gap = a.length;
		boolean swapped = false;

		while (gap > 1 || swapped) {
			swapped = false;
			gap = (int) (gap / 1.3);
			if (gap < 1) {
				gap = 1;
			}

			for (int i = 0; i + gap < a.length; i++) {
				if (a[i].compareTo(a[i + gap]) > 0) {
					Collections.swap(Arrays.asList(a), i, i + gap);
					swapped = true;
				}
			}
		}
	}
}
