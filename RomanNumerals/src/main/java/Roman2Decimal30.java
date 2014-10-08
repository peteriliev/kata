package main.java;

import java.util.HashMap;
import java.util.Map;

public class Roman2Decimal30 {

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

	public static int foo(final String string) {
		int result = 0;

		int previous = Integer.MAX_VALUE;
		for (final char c : string.toCharArray()) {
			int val = map.get(c);
			result += val;
			if (val > previous) {
				result -= 2 * previous;
			}
			previous = val;
		}

		return result;
	}
}
