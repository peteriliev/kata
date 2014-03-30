package com.iliev.peter.kata;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class Decimal2Roman2 {

	private static SortedMap<Integer, String> result = new TreeMap<>();

	static {
		result.put(1, "I");

		result.put(4, "IV");
		result.put(5, "V");

		result.put(9, "IX");
		result.put(10, "X");

		result.put(40, "XL");
		result.put(50, "L");

		result.put(90, "XC");
		result.put(100, "C");

		result.put(400, "CD");
		result.put(500, "D");

		result.put(900, "CM");
		result.put(1000, "M");
	}

	public static String foo(final int decimal)
	{
		String result2 = "";
		int remainder = decimal;

		final Integer[] set = result.keySet().toArray(new Integer[result.size()]);
		Arrays.sort(set);

		for (int i = set.length - 1; i >= 0; i--) {
			final Integer y = set[i];
			while (y <= remainder && remainder > 0) {
				result2 += result.get(y);
				remainder -= y;
			}
		}

		return result2;
	}
}
