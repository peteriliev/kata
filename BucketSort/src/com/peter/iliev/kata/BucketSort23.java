package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort23 {

	public static int calcNumBuckets(final int numElem, final int bucketSize)
	{
		if (numElem < 0) {
			throw new IllegalArgumentException("numElem < 0");
		}
		if (bucketSize < 1) {
			throw new IllegalArgumentException("bs < 1");
		}

		return (numElem + bucketSize - 1) / bucketSize;
	}

	private static final int BUCKET_SIZE = 2;

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int max = Collections.max(Arrays.asList(a));
		final int min = Collections.min(Arrays.asList(a));
		final int numElem = max - min + 1;
		final int nBuckets = calcNumBuckets(numElem, BUCKET_SIZE);

		List[] buckets = new ArrayList[nBuckets];

		for (final int i : a) {
			final int targetBucket = (i - min) / BUCKET_SIZE;
			if (buckets[targetBucket] == null) {
				buckets[targetBucket] = new ArrayList<Integer>();
			}
			buckets[targetBucket].add(i);
		}

		int offset = 0;
		for (final List<Integer> bucket : buckets) {
			if (null == bucket) {
				continue;
			}

			int snap = offset;
			for (final Integer i : bucket) {
				a[offset++] = i;
			}
			InsertionSort23.sort(a, snap, offset - 1);
		}
	}
}
