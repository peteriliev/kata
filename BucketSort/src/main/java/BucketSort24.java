package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort24 {

	private final static int BUCKET_SIZE = 2;

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int max = Collections.max(Arrays.asList(a));
		final int min = Collections.min(Arrays.asList(a));
		final int numBuckets = calcNumBuckets(max - min + 1, BUCKET_SIZE);

		final List[] buckets = new ArrayList[numBuckets];

		for (final int i : a) {
			final int target = (i - min) / BUCKET_SIZE;
			if (buckets[target] == null) {
				buckets[target] = new ArrayList<>();
			}

			buckets[target].add(i);
		}

		int offset = 0;
		for (final List bucket : buckets) {
			if (null == bucket) {
				continue;
			}

			final int snapshot = offset;
			for (final Object obj : bucket) {
				if (null == obj) {
					continue;
				}
				a[offset++] = (Integer) obj;
			}
			InsertionSort24.sort(a, snapshot, offset - 1);
		}

	}

	public static int calcNumBuckets(final int numElem, final int bucketSize)
	{
		if (numElem < 0) {
			throw new IllegalArgumentException("numElem < 0");
		}

		if (bucketSize < 1) {
			throw new IllegalArgumentException("bucketSize < 1");
		}

		return (numElem + bucketSize - 1) / bucketSize;
	}

}
