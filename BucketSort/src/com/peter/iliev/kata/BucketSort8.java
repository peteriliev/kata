package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.List;

public class BucketSort8 {

	private static final int BUCKET_SIZE = 2;

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
		
		final int length = max - min + 1;
		final int N_BUCKETS = calcNumBuckets(length, BUCKET_SIZE);
		final List<Integer>[] buckets = new ArrayList[N_BUCKETS];
		
		for (final int i : a) {
			final int target = (i - min) / BUCKET_SIZE;
			if (buckets[target] == null) {
				buckets[target] = new ArrayList<Integer>();
			}
			buckets[target].add(i);
		}
		
		int counter = 0;
		for (int b = 0; b < N_BUCKETS; b++) {
			if(buckets[b] == null) {
				continue;
			}
			final int offset = counter;
			for (final int i : buckets[b]) {
				a[counter++] =i;
			}
			InsertionSort8.sort(a, offset, counter - 1);
		}
	}

	public static int calcNumBuckets(final int nElements, final int bucketSize) {
		if (bucketSize <= 0) {
			throw new IllegalArgumentException();
		}

		if (nElements <= 0) {
			return 0;
		}
		return (nElements + bucketSize - 1) / bucketSize;
	}

}
