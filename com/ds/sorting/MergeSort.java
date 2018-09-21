package com.ds.sorting;

import static com.ds.sorting.SortTest.test;

public class MergeSort {

    public static void sort(int[] data)
    {
        divide(data, 0, data.length);
    }

    private static void divide(int[] data, int startIndex, int endIndex)
    {
        /** start Inclusive and end Exclusive**/
        final int nelem = endIndex-startIndex;
        if( nelem <= 1)
            return; //Zero or One element which is already sorted

        int midIndex = startIndex + nelem/2;
        divide(data, startIndex, midIndex);
        divide(data, midIndex, endIndex);
        merge(data, startIndex, midIndex, endIndex);
    }

    private static void merge(int[] data, int startIndex, int midIndex, int endIndex) {

        for(int temp_index = midIndex; temp_index < endIndex; temp_index++)
        {
            final int data_elem = data[temp_index];
            int one_minus = temp_index-1, curr_index=temp_index;
            while(curr_index > startIndex && data[one_minus] > data_elem)
            {
                data[curr_index] = data[one_minus];
                curr_index = one_minus;
                one_minus--;
            }
            if (data[curr_index] == data_elem)  break;

            data[curr_index] = data_elem;
        }
    }

    public static void main(String... strings)
    {

        test(MergeSort::sort);

    }
}
