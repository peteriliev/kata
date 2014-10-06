package main.java;

import java.util.ArrayList;
import java.util.List;

public class RS2 {

	public static void sort(final Integer[] a) {
		
		if (a == null) {
			throw new IllegalArgumentException();
		}
		
		if (a.length <= 1) {
			return;
		}
		
		int min = a[0];
		for (final Integer i:a) {
			min = Math.min(min, i);
		}
		
		final List[] bins = new ArrayList[10];
		
		for (int r = 1; r < 100; r++ ) {
			initBins(bins);
			for (final Integer i : a) {
				final int ls = getSignificant(i - min, r);
				bins[ls].add(i - min);
			}
			
			int counter = 0;
			for (final List bin: bins){
				for (final Object foo : bin) {
					final Integer iFoo = (Integer)foo;
					a[counter++] = iFoo + min;
				}
			}
		}
	}
	
	private static int getSignificant(final int i, final int radix) {
		final int mod = (int) Math.pow(10, radix);
		final int n = (int) Math.pow(10, radix - 1);
		
		return (i % mod) / n;
	}
	
	private static void initBins(final List[] bins) {
		for (int i = 0; i < bins.length; i++) {
			if (bins[i] == null) {
				bins[i] = new ArrayList<>();
			} else {
				bins[i].clear();
			}
		}
	}
}
