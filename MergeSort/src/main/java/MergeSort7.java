package main.java;

import java.util.ArrayList;
import java.util.List;

public class MergeSort7
{

    public static <T extends Comparable<T>> void sort(final T[] a)
    {
        if (a.length <= 1)
        {
            return;
        }
        sortInternal(a, 0, a.length - 1);
    }

    private static <T extends Comparable<T>> void sortInternal(final T[] a, final int from, final int to)
    {
        final int length = to - from + 1;
        if (length <= 1)
        {
            return;
        }

        int middle = from + ((length / 2));
        
        sortInternal(a, from, middle - 1);
        sortInternal(a, middle, to);
        
        merge(a, from, middle -1, middle, to);
    }
    
    private static <T extends Comparable<T>> void merge(final T[] a, final int f1, final int t1, final int f2, final int t2)
    {
        final int length = t2 - f1  + 1;
        int s1= f1;
        int s2 = f2;
        final List<T> tmp = new ArrayList<T>(length);
        
        for (int i = 0; i < length; i++) {
            if (s1 > t1) {
                tmp.add(a[s2++]);
            } else  if (s2 > t2) {
                tmp.add(a[s1++]);
            } else if (a[s1].compareTo(a[s2]) < 0) {
                tmp.add(a[s1++]);
            } else {
                tmp.add(a[s2++]);
            }
        }
        
        s1 = f1;
        for(final T t : tmp) {
            a[s1++] = t;
        }
    }    
}
