package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort211 {

	public static int calcNumBuckets(final int numEleem, final int bucketSize)
	{
		if (bucketSize < 1) {
			throw new IllegalArgumentException();
		}

		if (numEleem < 0) {
			throw new IllegalArgumentException();
		}

		return (bucketSize + numEleem - 1) / bucketSize;
	}

	private final static int BUCKET_SIZE = 2;

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		final int len = max - min + 1;
		final int numBuckets = calcNumBuckets(len, BUCKET_SIZE);

		List[] buckets = new ArrayList[numBuckets];

		for (final Integer i : a) {
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
			int snap = offset;
			for (final Object o : bucket) {
				a[offset++] = (Integer) o;
			}
			InsertionSort211.sort(a, snap, offset - 1);
		}
	}
}
