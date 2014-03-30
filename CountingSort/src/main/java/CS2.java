package com.iliev.peter.kata;

import java.util.Map;
import java.util.TreeMap;

public class CS2 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		Map<T, Integer> histogram = new TreeMap<T, Integer>();
		
		for (final T t:a) {
			if (!histogram.containsKey(t)) {
				histogram.put(t, 1);
			} else {
				histogram.put(t, histogram.get(t) + 1);
			}
		}
		
		int index = 0;
		for (final T key : histogram.keySet()) {
			int count = histogram.get(key);
			while(count-- > 0) {
				a[index++] = key;
			}
		}
	}
}
