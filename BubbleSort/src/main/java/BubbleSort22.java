package main.java;

import java.util.Arrays;
import java.util.Collections;

public class BubbleSort22 {
	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		for (int i = 0; i < a.length; i++) {

			boolean swapped = false;
			for (int j = a.length - 1; j - 1 >= i; j--) {
				if (a[j].compareTo(a[j - 1]) < 0) {
					Collections.swap(Arrays.asList(a), j, j - 1);
					swapped = true;
				}
			}

			if (!swapped) {
				break;
			}
		}
	}
}
