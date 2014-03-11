package com.iliev.peter.kata;

public class QuickSort7
{

    public static <T extends Comparable<T>> void sort(final T[] a)
    {
        if (a.length <= 1)
        {
            return;
        }

        sortInternal(a, 0, a.length - 1);
    }

    private static <T extends Comparable<T>> void sortInternal(final T[] a, final int start, final int endInc)
    {
        if (endInc - start < 1) {
            return;
        }
        
        int left = start;
        int pivot = left;
        final T pivotValue = a[pivot];
        int right = endInc;
        
        while (left < right) {
            while (right > left && a[right].compareTo(pivotValue) >= 0) {
                right--;
            }
            
            if (right > left) {
                swap(a, right, pivot);
                pivot = right;
                left++;
            }
            
            while (left < right && a[left].compareTo(pivotValue) <= 0) {
                left++;
            }
            
            if (left < right) {
                swap(a,  left, pivot);
                pivot = left;
                right--;
            }
        }
        sortInternal(a, start, pivot - 1);
        sortInternal(a, pivot + 1, endInc);
    }
    
    private static <T extends Comparable<T>> void swap(final T[] a, final int start, final int endInc) {
        final T tmp = a[start];
        a[start] = a[endInc];
        a[endInc] = tmp;
    }
}
