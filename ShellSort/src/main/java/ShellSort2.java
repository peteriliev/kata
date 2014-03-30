package com.iliev.peter.kata;

public class ShellSort2 {

	public static <T extends Comparable<T>> void sort(final T[] a) {
		final int[] gaps = { 701, 301, 132, 57, 23, 10, 4, 1 };

		for (final int gap : gaps) {

			for (int i = 0; i + gap < a.length; i++) {

				for (int j = i + gap; j < a.length; j +=gap) {
					final T liftee = a[j];
					int x = j - gap;
					while (x >= i && a[x].compareTo(liftee) > 0) {
						a[x + gap] = a[x];
						x -= gap;
					}
					
					a[x + gap] = liftee;
				}
			}
		}
	}
}
