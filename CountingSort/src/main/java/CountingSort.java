package com.iliev.peter.kata;

import java.util.SortedMap;
import java.util.TreeMap;

public class CountingSort {

	public static <T extends Comparable<T>> void sort(final T[] a) {

		// 1. Build histogram
		SortedMap<T, Integer> map = new TreeMap<T, Integer>();
		
		for (T t : a) {
			if (!map.containsKey(t)) {
				map.put(t, 1);
			} else {
				map.put(t, map.get(t) + 1);
			}
		}

		int index = 0;
		// 2. Sort
		for (T k : map.keySet()) {
			int count = map.get(k);
			
			while(count-- > 0){
				a[index++] = k;
			}
		}
	}
}
