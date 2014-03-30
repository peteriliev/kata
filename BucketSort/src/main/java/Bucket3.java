package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.List;

public class Bucket3 {

	private static final int BUCKET_SIZE = 2;

	public static void sort(final Integer[] a) {
		if (a == null || a.length <= 1) {
			return;
		}
		
		int min = a[0];
		int max = a[0];
		for (final int i : a) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		
		final int nBuckets = calcNumBuckets(max - min + 1, BUCKET_SIZE);
		final List[] bins = new ArrayList[nBuckets];
		
		for (final int i : a) {
			final int targetBin = (i - min) / BUCKET_SIZE;
			if (bins[targetBin] == null) {
				bins[targetBin] = new ArrayList<Integer>();
			}
			
			bins[targetBin].add(i - min);
		}
		
		int counter = 0;
		for (final List<Integer> bin : bins) {
			if (bin == null) {
				continue;
			}
			
			for (final int i : bin) {
				a[counter++] = i + min;
			}
			
			Insert3.sort(a, counter - bin.size(), counter - 1);
		}
		
		
	}

	public static int calcNumBuckets(final int length, final int bucketSize) {
		return (length + bucketSize - 1) / bucketSize;
	}
}
