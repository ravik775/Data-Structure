package com.ds.sorting;

import static com.ds.sorting.SortTest.test;

public class InsertionSort {

    public static void sort(int[] data)
    {
        for(int index1 = 0; index1 < data.length ; index1++)
        {
            int data_elem = data[index1];
            int index2 = index1-1;
            while(index2 >= 0 && data[index2] > data_elem)
            {
                data[index2+1] = data[index2];
                index2--;
            }
            data[index2+1] = data_elem;
        }

    }

    public static void main(String... strings)
    {
        test(InsertionSort::sort);
    }
}
