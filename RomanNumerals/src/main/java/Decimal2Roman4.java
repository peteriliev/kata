package main.java;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Decimal2Roman4 {

	private static SortedMap<Integer, String> map = new TreeMap<>(new MyCompa());
	
	private static class MyCompa implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2)
		{
			return o2 - o1;
		}
	}
	
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
	
	public static String foo(final int decimal)
	{
		String result = "";
		int tmp = decimal;
		for (Integer key : map.keySet()) {
			while (tmp >= key) {
				result += map.get(key);
				tmp -= key;
			}
		}
		
		return result;
	}
}
