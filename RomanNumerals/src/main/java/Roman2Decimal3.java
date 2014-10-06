package main.java;

import java.util.HashMap;
import java.util.Map;

public class Roman2Decimal3 {

	private final static Map<String, Integer> map = new HashMap<String, Integer>();

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
		for (int i = 0; i < roman.length(); i++) {
			final String rd = ((Character) roman.toCharArray()[i]).toString();
			final int value = map.get(rd);

			result += value;
			if (previous < value) {
				result -= previous * 2;
			}
			previous = value;
		}

		return result;
	}
}
