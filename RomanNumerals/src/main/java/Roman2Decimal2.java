package com.iliev.peter.kata;

import java.util.HashMap;
import java.util.Map;

public class Roman2Decimal2 {

	private final static Map<Character, Integer> map = new HashMap<>();

	static {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}

	public static int foo(final String roman)
	{
		int result = 0;
		int lastVal = Integer.MAX_VALUE;
		for (final Character c : roman.toCharArray()) {

			final int decimal = map.get(c);

			result += decimal;
			if (lastVal < decimal) {
				result -= lastVal * 2;
			}

			lastVal = decimal;

		}

		return result;
	}

}
