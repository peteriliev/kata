package main.java;

import java.util.ArrayList;
import java.util.List;

public class RS4 {

	public static void sort(final Integer[] a) {
		if (a.length <= 1) {
			return;
		}
		
		int min = a[0];
		for (final int i : a) {
			min = Math.min(min, i);
		}
		
		final List[] bins = new ArrayList[10];
		
		int radd = 1;
		boolean flag = true;
		while(flag) {
			flag = false;
			initBins(bins);
			
			for (final int i : a) {
				final int sig = getSignificant(i - min, radd);
				if (sig > 0) {
					flag = true;
				}
				bins[sig].add(i - min);
			}
			radd++;
			
			int counter = 0;
			for (final List bin: bins) {
				for (final Object i : bin) {
					a[counter++] = (Integer)i + min;
				}
			}
		}

	}

	private final static void initBins(final List[] bins) {
		for (int i = 0; i < bins.length; i++) {
			if (bins[i] == null) {
				bins[i] = new ArrayList<>();
			} else {
				bins[i].clear();
			}
		}
	}

	public static int getSignificant(final int number, final int radix) {
		final int r = (int) Math.pow(10, radix);

		final int n = (int) Math.pow(10, radix - 1);

		return (number % r) / n;
	}
}