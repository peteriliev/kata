package main.java;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Decimal2Roman30 {

	static Map<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});

	static {
		map.put(1000, "M");
		map.put(900, "CM");

		map.put(500, "D");
		map.put(400, "CD");

		map.put(100, "C");
		map.put(90, "XC");

		map.put(50, "L");
		map.put(40, "XL");

		map.put(10, "X");
		map.put(9, "IX");

		map.put(5, "V");
		map.put(4, "IV");

		map.put(1, "I");
	}

	public static String foo(final int decimal) {
		String result = "";
		int tmp = decimal;

		for (final int key : map.keySet()) {
			final String val = map.get(key);

			while (tmp >= key) {
				result += val;
				tmp -= key;
			}
		}

		return result;
	}
}
