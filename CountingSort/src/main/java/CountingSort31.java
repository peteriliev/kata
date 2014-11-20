package main.java;

import java.util.Arrays;
import java.util.Collections;

public class CountingSort31 {

	public static void sort(final Integer[] a) {
		if (a.length < 2) {
			return;
		}

		final int min = Collections.min(Arrays.asList(a));
		final int max = Collections.max(Arrays.asList(a));
		final int len = max - min + 1;

		final int counts[] = new int[len];

		for (final int i : a) {
			counts[i - min]++;
		}

		int snapshot = a.length;
		for (int i = len - 1; i >= 0; i--) {
			System.out.println();
			System.out.printf("Snapshot - counts[i] = %d, snapshop = %d, i = %d, a.length  = %d", snapshot - counts[i], snapshot, i, a.length);
			System.out.println();
			
			Arrays.fill(a, snapshot - counts[i], snapshot, i + min);
			snapshot -= counts[i];
		}

		//Collections.reverse(Arrays.asList(a));
	}
}
