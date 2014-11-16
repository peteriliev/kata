package main.java;

import java.util.Arrays;
import java.util.Collections;

public class MergeSort31 {

	public static <T extends Comparable<T>> void sort(final T[] a)
	{
		sortInternal(a, 0, a.length - 1);
		Collections.reverse(Arrays.asList(a));
	}

	private static <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int end)
	{
		final int len = end - start + 1;
		if (len < 2) {
			return;
		}
		final int middle = start + len / 2;

		sortInternal(a, start, middle - 1);
		sortInternal(a, middle, end);

		merge(a, start, middle - 1, middle, end);
	}

	private static <T extends Comparable<T>> void merge(final T[] a, final int start1, final int end1,
			final int start2, final int end2)
	{
		final int len = end2 - start1 + 1;
		int s1 = end1;
		int s2 = end2;
		final Object[] tmp = new Object[len];

		for (int i = len - 1; i >= 0; i--) {
			if (s1 < start1) {
				tmp[i] = a[s2--];
			} else if (s2 < start2) {
				tmp[i] = a[s1--];
			} else if (a[s1].compareTo(a[s2]) < 0) {
				tmp[i] = a[s1--];
			} else {
				tmp[i] = a[s2--];
			}
		}

		s1 = start1;
		for (final Object obj : tmp) {
			a[s1++] = (T) obj;
		}
	}
}
