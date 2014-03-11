package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.List;

public class BucketSort5 {

	public static int calcNumBuckets(final int numElements, final int bucketSize) {
		return (numElements + bucketSize - 1) / bucketSize;
	}
	
	private final static int BUCKET_SIZE = 2;

	public static void sort(final Integer[] a) {
		
		if (a.length <= 1) {
			return;
		}
		
		
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
		
		final int num_buckests = calcNumBuckets(max - min + 1, BUCKET_SIZE);
		final List[] buckets = new ArrayList[num_buckests];
		
		for (final int i : a) {
			final int targetBucket = (i - min) / BUCKET_SIZE;
			if (buckets[targetBucket] == null) {
				buckets[targetBucket] = new ArrayList();
			}
			buckets[targetBucket].add(i);
		}
		
		int counter = 0;
		for (final List bucket : buckets) {
			if (bucket == null) {
				continue;
			}
			final int start = counter;
			for (final Object obj:bucket) {
				final Integer i = (Integer)obj;
				a[counter++] = i;
			}
			InsertionSort5.sort(a, start, counter - 1);
		}
	}
}
