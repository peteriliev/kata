package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort22 {

	private static final int BUCKET_SIZE = 2;

	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		final int len = max - min + 1;

		final int numElem = calcNumBuckets(len, BUCKET_SIZE);

		final List<Integer>[] buckets = new ArrayList[numElem];

		for (final int i : a) {
			final int targetBucket = (i - min) / BUCKET_SIZE;
			if (buckets[targetBucket] == null) {
				buckets[targetBucket] = new ArrayList<>();
			}
			buckets[targetBucket].add(i);
		}

		int offset = 0;
		for (int buckect = 0; buckect < numElem; buckect++) {
			if (buckets[buckect] == null) {
				continue;
			}
			final int snapshot = offset;
			for (final Integer i : buckets[buckect]) {
				a[offset++] = i;
			}

			InsertionSort22.sort(a, snapshot, offset - 1);
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
