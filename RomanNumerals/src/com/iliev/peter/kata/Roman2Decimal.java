package com.iliev.peter.kata;

import java.util.HashMap;
import java.util.Map;

public class Roman2Decimal {

	final static Map<Character, Integer> map = new HashMap<>();

	static {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}

	public static int foo(final String roman) {
		int result = 0;
		for (int i = 0; i < roman.length(); i++) {
			final char c = roman.charAt(i);
			final int val = map.get(c);

			result += val;
			if (i - 1 >= 0 && map.get(roman.charAt(i)) > map.get(roman.charAt(i - 1))) {
				result -= 2 * map.get(roman.charAt(i - 1));
			}
		}

		return result;
	}
}
