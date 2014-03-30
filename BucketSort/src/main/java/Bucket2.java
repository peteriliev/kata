package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.List;

public class Bucket2 {

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
		final int bucketCount = calcNumBuckets(length, BUCKET_SIZE);

		List[] bins = new ArrayList[bucketCount];

		for (final Integer i : a) {
			final int binIndex = getBucketsInddex(i - min, BUCKET_SIZE);
			if (bins[binIndex] == null) {
				bins[binIndex] = new ArrayList<Integer>();
			}
			bins[binIndex].add(i - min);
		}

		int counter = 0;
		for (final List bin : bins) {
			if (bin == null) {
				continue;
			}

			int start = counter;
			for (final Object i : bin) {
				a[counter++] = (Integer) i + min;
			}
			Insert2.sort(a, start, counter - 1);
		}
	}

	public static int getBucketsInddex(final int elementIndex, final int size) {
		return elementIndex / size;
	}

	public static int calcNumBuckets(final int elementCount, final int size) {
		return (elementCount + size - 1) / size;
	}
}
