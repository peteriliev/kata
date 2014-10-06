package main.java;

public class QuickSort11 {

    public static <T extends Comparable<T>> void sort(final T[] a) {
	if (1 >= a.length) {
	    return;
	}

	sortInternal(a, 0, a.length - 1);
    }

    public static <T extends Comparable<T>> void sortInternal(final T[] a, final int s, final int eInc) {
	if (s >= eInc) {
	    return;
	}

	int left = s;
	int right = eInc;
	int pivot = left;
	final T pivotValue = a[pivot];

	while (left < right) {
	    while (right > left && a[right].compareTo(pivotValue) >= 0) {
		right--;
	    }

	    if (right > left) {
		swap(a, right, pivot);
		pivot = right;
		left++;
	    }

	    while (left < right && a[left].compareTo(pivotValue) <= 0) {
		left++;
	    }

	    if (left < right) {
		swap(a, left, pivot);
		pivot = left;
		right--;
	    }
	}

	sortInternal(a, s, pivot - 1);
	sortInternal(a, pivot + 1, eInc);

    }

    private static <T extends Comparable<T>> void swap(final T[] a, final int x, final int y) {
	final T tmp = a[x];
	a[x] = a[y];
	a[y] = tmp;
    }
}
