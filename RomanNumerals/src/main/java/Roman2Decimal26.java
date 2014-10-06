package main.java;

import java.util.HashMap;
import java.util.Map;

public class Roman2Decimal26 {

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
		int decimal = 0;

		final char[] a = roman.toCharArray();

		int last = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			final int current = map.get(a[i]);
			decimal += current;
			if (last < current) {
				decimal -= 2 * last;
			}
			last = current;

		}

		return decimal;
	}
}
