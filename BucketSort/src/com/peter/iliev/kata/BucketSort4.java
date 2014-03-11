package com.peter.iliev.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort4 {
	public static final int BUCKET_SIZE = 2;
	
	public static void sort(final Integer[] a) {
		if (a.length <= 1) {
			return;
		}
		final int min = getMin(a);
		final int max = getMax(a);
		final int range = max - min + 1;
		
		final int N_BUCKETS = calcNumBuckets(range, BUCKET_SIZE);
		
		System.out.println(String.format("Array = %s, N_BUCKETS = %s", Arrays.toString(a), N_BUCKETS));
		
		List[] buckets = new ArrayList[N_BUCKETS];
		
		for (final int i : a) {
			final int TARGET = (i - min) / BUCKET_SIZE;
			if (buckets[TARGET] == null) {
				buckets[TARGET] = new ArrayList<Integer>();
			}
			buckets[TARGET].add(i);
		}
		
		int counter = 0;
		for (int b = 0; b < N_BUCKETS; b++) {
			if (buckets[b] == null) {
				continue;
			}
			int start = counter;
			for (final Object i : buckets[b]) {
				a[counter++] = (Integer)i;
			}
			InsertionSort4.sort(a, start, counter - 1);
		}
	}
	
	public static int calcNumBuckets(final int count, final int size) {
		if (count == 0) {
			return 0;
		}
		if (size <= 0) {
			throw new IllegalArgumentException();
		}
		
		return (count + size -1)/ size;
	}
	
	private static int getMin(final Integer[] a) {
		assert (a != null);
		assert (a.length > 0);
		int result = Integer.MAX_VALUE;
		for (final int i : a) {
			if (result > i) {
				result = i;
			}
		}
		return result;
	}
	
	private static int getMax(final Integer[] a) {
		assert (a != null);
		assert (a.length > 0);
		int result = Integer.MIN_VALUE;
		for (final int i : a) {
			if (result < i) {
				result = i;
			}
		}
		return result;
	}
}
