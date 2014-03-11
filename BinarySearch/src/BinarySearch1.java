
public class BinarySearch1 {
	public static final <T extends Comparable<T>> int search(final T[] a, final T target) {
		
		return searchInternal(a, 0, a.length - 1, target);
		
	}

	private static final <T extends Comparable<T>> int searchInternal(final T[] a, final int start, final int end, final T target) {
		final int len = end - start + 1;
	
		if (len < 1) {
			return Integer.MIN_VALUE;
		}
		
		final int middle = start + (len / 2);
		
		final int foo = target.compareTo(a[middle]);
		if (foo == 0) {
			return middle;
		}
		
		if (len == 1) {
			return Integer.MIN_VALUE;
		}
		
		if (foo < 0) {
			return searchInternal(a, start, middle - 1, target);
		} else {
			return searchInternal(a, middle + 1, start, target);
		}
	}
}
