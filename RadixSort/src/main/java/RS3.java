package main.java;

import java.util.ArrayList;
import java.util.List;

public class RS3 {

	public static void sort(final Integer[] a) {
		
		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		if (a.length <= 1) {
			return;
		}
		
		List[] bins = new ArrayList[10];
			
		int min = a[0];
		for (final Integer i:a) {
			min = Math.min(min, i);
		}
		
		for (int radix = 1; radix < 100; radix++) {
			initBins(bins);
			
			for (final Integer i : a) {
				final int leasetSing = getSignificant(i - min, radix);
				bins[leasetSing].add(i - min);
			}
			
			int counter = 0;
			for (final List bin:bins) {
				for (final Object i : bin) {
					a[counter++] = (Integer)i + min;
				}
			}
		}
	}
	
	// index is 1 based
	public static int getSignificant(final int value, final int index) {
		if (index <= 0) {
			throw new IllegalArgumentException();
		}
		
		final int mod = (int) Math.pow(10, index);
		final int n = (int) Math.pow(10, index - 1);
		
		return (value % mod) / n;
	}

	private static void initBins(final List[] bins) {
		for (int i = 0; i < bins.length; i++) {
			if (bins[i] != null) {
				bins[i].clear();
			} else {
				bins[i] = new ArrayList<>();
			}
		}
	}
}
