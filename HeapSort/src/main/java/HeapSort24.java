package main.java;

import java.util.Arrays;
import java.util.Collections;

public class HeapSort24 {

	public static void sort(final Integer[] a)
	{
		for (int i = 1; i < a.length; i++) {
			int index = i;
			int parent = getParent(index);
			while (NULL_INDEX != parent && a[index].compareTo(a[parent]) > 0) {
				Collections.swap(Arrays.asList(a), index, parent);
				index = parent;
				parent = getParent(parent);
			}
		}

		System.out.println(Arrays.toString(a));

		for (int i = a.length - 1; i > 0; i--) {
			Collections.swap(Arrays.asList(a), i, 0);
			int index = 0;
			int greaterChild = getGreaterChild(a, index, i - 1);
			while (NULL_INDEX != greaterChild && a[greaterChild].compareTo(a[index]) > 0) {
				Collections.swap(Arrays.asList(a), index, greaterChild);
				index = greaterChild;
				greaterChild = getGreaterChild(a, index, i - 1);
			}
		}
	}

	private static final int NULL_INDEX = -1;

	private static int get1Child(final int index, final int boundary)
	{
		final int tmp = index * 2 + 1;
		if (tmp > boundary) {
			return NULL_INDEX;
		}
		return tmp;
	}

	private static int get2Child(final int index, final int boundary)
	{
		final int tmp = index * 2 + 2;
		if (tmp > boundary) {
			return NULL_INDEX;
		}
		return tmp;
	}

	private static int getParent(final int index)
	{
		final int tmp = (index - 1) / 2;
		if (tmp < 0) {
			return NULL_INDEX;
		}
		return tmp;
	}

	private static int getGreaterChild(final Integer[] a, final int index, final int boundary)
	{
		final int c1 = get1Child(index, boundary);
		final int c2 = get2Child(index, boundary);

		if (NULL_INDEX == c1 && NULL_INDEX == c2) {
			return NULL_INDEX;
		}

		if (NULL_INDEX == c1) {
			return c2;
		}

		if (NULL_INDEX == c2) {
			return c1;
		}

		if (a[c1].compareTo(a[c2]) > 0) {
			return c1;
		} else {
			return c2;
		}
	}

}
