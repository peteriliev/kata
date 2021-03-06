package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort39 {

	private static final int BUCKET_SIZE = 2;

	public static void sort(final Integer[] a) {

		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		final int numElem = max - min + 1;

		final int numBuckets = calcNumBuckets(numElem, BUCKET_SIZE);

		List<Integer>[] buckets = new ArrayList[numBuckets];

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
			final int snapshot = offset;
			for (final int i : bucket) {
				a[offset++] = i;
			}
			InsertionSort39.sort(a, snapshot, offset - 1);
		}
	}

	public static int calcNumBuckets(final int numElem, final int bucketSize) {
		if (numElem < 0) {
			throw new IllegalArgumentException("ne < 0");
		}
		if (bucketSize < 1) {
			throw new IllegalArgumentException("bs < 1");
		}

		return (numElem + bucketSize - 1) / bucketSize;
	}
}
