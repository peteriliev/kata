package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort31 {

	public static void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		final int numElem = max - min + 1;
		final int numBuckets = calcNumBuckets(numElem, 2);

		final List<Integer>[] buckets = new ArrayList[numBuckets];

		for (final int i : a) {
			final int targetBucket = (i - min) / 2;
			if (null == buckets[targetBucket]) {
				buckets[targetBucket] = new ArrayList<Integer>();
			}
			buckets[targetBucket].add(i);
		}

		int offset = 0;
		for (final List<Integer> bucket : buckets) {
			final int snapshot = offset;
			if (null == bucket) {
				continue;
			}

			for (final Integer i : bucket) {
				if (null == i) {
					continue;
				}

				a[offset++] = i;
			}

			InsertionSort31.sort(a, snapshot, offset - 1);
		}
	}

	public static int calcNumBuckets(final int numElem, final int bucketSize) {
		if (numElem < 0) {
			throw new IllegalArgumentException("numElem < 0");
		}

		if (bucketSize < 1) {
			throw new IllegalArgumentException("bucketSize < 1");
		}

		if (numElem == 0) {
			return 0;
		}

		return (bucketSize + numElem - 1) / bucketSize;
	}
}
