package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort25 {

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

	private final static int BUCKET_SIZE = 2;
	
	public static void sort(final Integer[] a)
	{
		if (a.length < 2) {
			return;
		}
		
		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		
		final int numBuckets = calcNumBuckets(max - min + 1, BUCKET_SIZE);
		
		final List[] buckets = new List[numBuckets];
		
		for (final Integer i : a) {
			final int targetBucket = (i - min) / BUCKET_SIZE;
			if (buckets[targetBucket] == null) {
				buckets[targetBucket] = new ArrayList<Integer>();
			}
			buckets[targetBucket].add(i);
		}
		
		int start = 0;
		for (final List<Integer> bucket : buckets) {
			if (null == bucket) {
				continue;
			}
			
			final int snapShot = start;
			for (final Integer i : bucket ) {
				if (null == i) {
					continue;
				}
				a[start++] = i;
			}
			
			InsertionSort25.sort(a, snapShot, start - 1);
		}
	}
}