package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort30 {

	public static void sort(final Integer[] a) {
		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		final int numElem = max - min + 1;
		final int numBuckets = calcNumBuckets(numElem, 2);

		List<Integer>[] buckets = new List[numBuckets];

		for (final int i : a) {
			final int targetBucket = (i - min) / 2;
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
			for (final Integer i : bucket) {
				a[offset++] = i;
			}

			InsertionSort30.sort(a, snapshot, offset - 1);

		}
	}

	public static int calcNumBuckets(final int numElem, final int bucketSize) {
		if (numElem < 0) {
			throw new IllegalArgumentException("Illegal num elem");
		}

		if (bucketSize < 1) {
			throw new IllegalArgumentException("Illegal bucket size");
		}
		return (numElem + bucketSize - 1) / bucketSize;
	}
}
