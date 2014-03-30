package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.List;

public class BucketSort7 {

	public static int calcNumBuckets(final int numElemets, final int bucketSize) {
		if (bucketSize <= 0) {
			throw new IllegalArgumentException();
		}
		
		return (numElemets + bucketSize - 1) / bucketSize;
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
		
		final int n_buckest = calcNumBuckets(max - min + 1, BUCKET_SIZE);
		
		List<Integer>[] buckests = new ArrayList[n_buckest];
		for (final int i : a) {
			final int target = (i - min) / BUCKET_SIZE;
			if (buckests[target] == null) {
				buckests[target] = new ArrayList<Integer>();
			}
			buckests[target].add(i);
		}
		int offest = 0;
		for (final List<?> buck : buckests) {
			if (buck == null) {
				continue;
			}
			
			final int tmp = offest;
			for (final Object obj : buck) {
				int i = (Integer)obj;
				a[offest++] = i;
			}
			InsertionSort7.sort(a, tmp, offest - 1);
		}
	}

}
