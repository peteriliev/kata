package main.java;

import java.util.Arrays;
import java.util.Collections;

public class BubbleSort21 {
	public static <T extends Comparable<T>> void sort(final T[] a)
	{

		for (int j = a.length; j > 0; j--) {
			for (int i = 0; i + 1 < j; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					Collections.swap(Arrays.asList(a), i, i + 1);
				}
			}
		}
	}
}
