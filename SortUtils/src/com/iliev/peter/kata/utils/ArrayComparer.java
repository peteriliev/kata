package com.iliev.peter.kata.utils;

public class ArrayComparer {

	private ArrayComparer() {
	}
	
	public static <T extends Comparable<T>> boolean areEqualArrays(T[] a, T[] b) {
		if (a == null || b == null) {
			return false;
		}
		
		if (a.length != b.length) {
			return false;
		}
		
		for(int i = 0; i < a.length; i++) {
			if (a[i].compareTo(b[i]) != 0) {
				return false;
			}
		}

		return true;
	}
}