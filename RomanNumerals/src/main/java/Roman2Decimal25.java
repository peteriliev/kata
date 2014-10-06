package main.java;

import java.util.Hashtable;
import java.util.Map;

public class Roman2Decimal25 {

	final static Map<Character, Integer> map = new Hashtable<>();

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
		int tmp = Integer.MAX_VALUE;
		for (final char c : roman.toCharArray()) {
			int current = map.get(c);
			result += current;

			if (tmp < current) {
				result -= 2 * tmp;
			}
			tmp = current;
		}
		return result;
	}
}
