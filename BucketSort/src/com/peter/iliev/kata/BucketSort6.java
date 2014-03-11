package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.List;

public class BucketSort6 {

	public static int calcNumBuckets(final int num, int bucketSize) {
		if (bucketSize <= 0) {
			throw new IllegalArgumentException();
		}

		return (num + bucketSize - 1) / bucketSize;
	}

	private static final int BUCKET_SIZE = 2;

	public static void sort(final Integer[] a) {
		
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
		final int length = max - min + 1;

		final int numBuckest = calcNumBuckets(length, BUCKET_SIZE);

		List[] buckest = new ArrayList[numBuckest];

		for (final int i : a) {
			final int target = (i - min) / BUCKET_SIZE;
			if (buckest[target] == null) {
				buckest[target] = new ArrayList<Integer>();
			}
			buckest[target].add(i);
		}

		int counter = 0;
		for (int b = 0; b < numBuckest; b++) {
			if (buckest[b] == null) {
				continue;
			}
			int tmp = counter;
			for (final Object obj : buckest[b]) {
				a[counter++] = (Integer) obj;
			}
			InsertionSort6.sort(a, tmp, counter - 1);
		}
	}
}
