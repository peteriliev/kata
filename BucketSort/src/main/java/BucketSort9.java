package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.List;

public class BucketSort9 {

	public static void sort(final Integer[] a) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (final int i : a) {
			if (min > i) {
				min = i;
			}
			if (max < i) {
				max = i;
			}
		}

		final int numElem = max - min + 1;

		final int numBuckest = calcNumBuckets(numElem, BUCKET_SIZE);

		final List[] buckets = new List[numBuckest];

		for (final int i : a) {
			final int target = (i - min) / BUCKET_SIZE;
			if (buckets[target] == null) {
				buckets[target] = new ArrayList<Integer>();
			}
			buckets[target].add(i);
		}

		int counter = 0;
		for (final List<Integer> b : buckets) {
			if (null == b) {
				continue;
			}

			final int offset = counter;
			for (final int i : b) {
				a[counter++] = i;
			}
			InsertionSort9.sort(a, offset, counter - 1);
		}
	}

	private final static int BUCKET_SIZE = 2;

	public static int calcNumBuckets(final int numElem, final int size) {
		if (numElem <= 0) {
			return 0;
		}

		if (size <= 0) {
			throw new IllegalArgumentException();
		}

		return (numElem + size - 1) / size;
	}
}
