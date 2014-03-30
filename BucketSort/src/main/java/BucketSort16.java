package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.List;

public class BucketSort16 {

	public static int calcNumBuckets(final int numElem, final int bucketSize) {
		if (bucketSize < 1) {
			throw new IllegalArgumentException();
		}

		return (numElem + bucketSize - 1) / bucketSize;
	}

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

		final int len = max - min + 1;
		final int NUM_BUCKETS = calcNumBuckets(len, BUCKET_SIZE);
		List[] buckest = new ArrayList[NUM_BUCKETS];

		for (final int i : a) {
			final int target = (i - min) / BUCKET_SIZE;
			if (buckest[target] == null) {
				buckest[target] = new ArrayList<>();
			}
			buckest[target].add(i);
		}

		int offset = 0;
		for (final List bucket : buckest) {
			if (null == bucket) {
				continue;
			}
			final int snap = offset;
			for (final Object obj : bucket) {
				a[offset++] = (Integer) obj;
			}
			InsertionSort16.sort(a, snap, offset - 1);
		}
	}
}
