package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.List;

public class BucketSort14 {

	public static int calcNumBuckets(final int numElem, final int bucketSize) {
		if (numElem < 0) {
			throw new IllegalArgumentException();
		}

		if (bucketSize <= 0) {
			throw new IllegalArgumentException();
		}

		return (numElem + bucketSize - 1) / bucketSize;
	}

	private final static int BUCKET_SIZE = 2;

	public static void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (final int i : a) {
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
		}

		final int numBuckets = calcNumBuckets(max - min + 1, BUCKET_SIZE);
		List[] buckets = new ArrayList[numBuckets];

		for (int i = 0; i < a.length; i++) {
			final int num = a[i];
			final int target = (num - min) / BUCKET_SIZE;
			if (buckets[target] == null) {
				buckets[target] = new ArrayList<>();
			}
			buckets[target].add(num);
		}

		int offset = 0;
		for (final List bucket : buckets) {
			if (null == bucket) {
				continue;
			}

			int rec = offset;
			for (final Object obj : bucket) {
				a[offset++] = (Integer) obj;
			}
			InsertionSort14.sort(a, rec, offset - 1);
		}

	}
}
