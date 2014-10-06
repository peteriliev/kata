package main.java;

public class MS6 {
	public static<T extends Comparable<T>> void sort(final T[] a) {
		sortInternal(a, 0, a.length - 1);
	}

	public static<T extends Comparable<T>> void sortInternal(final T[] a, final int from, final int to) {
		final int length = to - from + 1;
		if (length <= 1) {
			return;
		}
		
		final int middle = from + length / 2;
		
		sortInternal(a, from, middle - 1);
		sortInternal(a, middle, to);
		
		merge(a, from, middle-1, middle, to);
	}
	
	private static<T extends Comparable<T>> void merge(final T[] a, final int s1, final int e1, final int s2, final int e2) {
		final int length = e2 - s1 + 1;
		
		final Object[] tmp = new Object[length];
		
		int start1 = s1;
		int start2 = s2;
		for (int i = 0; i < tmp.length; i++) {
			if (start1 > e1) {
				tmp[i] = a[start2++];
			} else if (start2 > e2) {
				tmp[i] = a[start1++];
			} else if (a[start1].compareTo(a[start2]) < 0) {
				tmp[i] = a[start1++];
			} else {
				tmp[i] = a[start2++];
			}
		}
		
		start1 = s1;
		for (final Object o : tmp) {
			a[start1++] = (T)o;
		}
	}

}
