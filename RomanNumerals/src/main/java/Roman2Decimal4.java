package com.iliev.peter.kata;

import java.util.Hashtable;
import java.util.Map;

public class Roman2Decimal4 {

	private static Map<String, Integer> map = new Hashtable<>();

	static {
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);

		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
	}

	public static int foo(final String roman)
	{
		int result = 0;

		int previous = Integer.MAX_VALUE;
		for (final Character c : roman.toCharArray()) {
			final int current = map.get(c.toString());
			result += current;
			if (current > previous) {
				result -= previous * 2;
			}
			previous = current;
		}

		return result;
	}

}
