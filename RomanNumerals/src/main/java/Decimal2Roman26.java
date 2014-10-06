package main.java;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Decimal2Roman26 {

	final static Map<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {

		@Override
		public int compare(final Integer o1, final Integer o2)
		{
			return o2 - o1;
		}
	});

	static {
		map.put(1, "I");

		map.put(4, "IV");
		map.put(5, "V");

		map.put(9, "IX");
		map.put(10, "X");

		map.put(40, "XL");
		map.put(50, "L");

		map.put(90, "XC");
		map.put(100, "C");

		map.put(400, "CD");
		map.put(500, "D");

		map.put(900, "CM");
		map.put(1000, "M");
	}

	public static String foo(final int decimal)
	{
		String roman = "";
		int tmp = decimal;

		for (final Integer key : map.keySet()) {
			while (tmp >= key) {
				roman += map.get(key);
				tmp -= key;
			}
		}

		return roman;
	}
}
