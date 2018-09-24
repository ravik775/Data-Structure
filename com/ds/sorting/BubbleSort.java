package com.ds.sorting;
import static com.ds.sorting.SortUtil.swap;
import static com.ds.sorting.SortTest.test;

public class BubbleSort {

    public static void sort(int[] data)
    {
        for(int index1 = data.length-1; index1 > 0 ; index1--)
        {
            for(int index2 = 0, nxt_index2=1; index2 < index1; index2=nxt_index2++)
                if(data[index2] > data[nxt_index2])
                    swap(data, index2, nxt_index2);
        }
    }

    public static void main(String... strings)
    {
        test(BubbleSort::sort);
    }
}
