package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

	public static final int BUCKET_SIZE = 2;

	public static void sort(final Integer[] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		if (a.length <= 1) {
			return;
		}

		int min = a[0];
		int max = a[0];

		for (final Integer i : a) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}

		final int length = max - min + 1;

		final int numBuckets = calcNumBuckets(length, BUCKET_SIZE);

		List[] buckets = new ArrayList[numBuckets];

		for (final Integer i : a) {
			final int bucketIndex = getBucketIndex(i - min, BUCKET_SIZE);
			if (buckets[bucketIndex] == null) {
				buckets[bucketIndex] = new ArrayList<Integer>();
			}
			buckets[bucketIndex].add(i - min);
		}
		
		int counter = 0;
		for (final List bucket : buckets) {
			if (bucket == null) {
				continue;
			}
			
			int start = counter;
			for (final Object i : bucket) {
				a[counter++] = (Integer)i + min;
			}
			
			InsertionSort.sort(a, start, counter - 1);
		}
	}

	private static int getBucketIndex(final int value, final int BucketSize) {
		return value / BucketSize;
	}

	public static int calcNumBuckets(int length, int bucketSize) {
		return (length + bucketSize - 1) / bucketSize;
	}
}