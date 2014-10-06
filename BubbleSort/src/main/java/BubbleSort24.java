package main.java;

import java.util.Arrays;
import java.util.Collections;

public class BubbleSort24 {

	public static <T extends Comparable<T>> void sort(final T[] a)
	{

		boolean swapped;
		for (int j = a.length; j > 0; j--) {
			swapped = false;
			for (int i = 0; i + 1 < j; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					Collections.swap(Arrays.asList(a), i, i + 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}
}
