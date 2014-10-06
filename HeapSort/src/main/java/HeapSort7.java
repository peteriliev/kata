package main.java;

import java.util.Arrays;

public class HeapSort7
{
    private static final int EMPTY_INDEX = -1;

    public static <T extends Comparable<T>> void sort(final T[] a)
    {
        if (a.length <= 1)
        {
            return;
        }

        buildHeap(a);
        System.out.println(String.format("Heap = %s", Arrays.toString(a)));

        sortHeap(a);
    }

    private static final <T extends Comparable<T>> void buildHeap(final T[] a)
    {
        for(int i = 1; i < a.length; i++)
        {
            int current = i;
            int parentIndex = getParentIndex(current);
            while(EMPTY_INDEX != parentIndex && a[parentIndex].compareTo(a[current]) < 0)
            {
                swap(a, current, parentIndex);
                current = parentIndex;
                parentIndex = getParentIndex(current);
            }
        }
    }

    private static final <T extends Comparable<T>> void sortHeap(final T[] a)
    {
        for(int i = a.length - 1; i > 0; i--)
        {
            swap(a, i, 0);
            int current = 0;
            int greaterChild = getGreaterChild(a, current, i);
            while(EMPTY_INDEX != greaterChild && a[greaterChild].compareTo(a[current]) > 0)
            {
                swap(a, current, greaterChild);
                current = greaterChild;
                greaterChild = getGreaterChild(a, current, i);
            }
        }
    }

    private static final <T extends Comparable<T>> int getGreaterChild(final T[] a, final int i, final int eX)
    {
        final int c1 = get1Child(i, eX);
        final int c2 = get2Child(i, eX);

        if (c1 == EMPTY_INDEX && c2 == EMPTY_INDEX)
        {
            return EMPTY_INDEX;
        }

        if (c1 == EMPTY_INDEX)
        {
            return c2;
        }

        if (c2 == EMPTY_INDEX)
        {
            return c1;
        }

        if (a[c1].compareTo(a[c2]) > 0)
        {
            return c1;
        }
        else
        {
            return c2;
        }
    }

    private static final <T extends Comparable<T>> void swap(final T[] a, final int i, final int j)
    {
        final T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int getParentIndex(final int index)
    {
        return (index - 1) / 2;
    }

    private static int get1Child(final int index, final int endEx)
    {
        final int tmp = index * 2 + 1;

        if (tmp >= endEx)
        {
            return EMPTY_INDEX;
        }

        return tmp;
    }

    private static int get2Child(final int index, final int endEx)
    {
        final int tmp = get1Child(index, endEx);

        if (tmp == EMPTY_INDEX)
        {
            return EMPTY_INDEX;
        }

        if (tmp >= endEx)
        {
            return EMPTY_INDEX;
        }

        if (tmp + 1 >= endEx)
        {
            return EMPTY_INDEX;
        }

        return tmp + 1;
    }
}
