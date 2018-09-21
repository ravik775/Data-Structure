package com.ds.sorting;

import static com.ds.sorting.SortTest.test;

public class BotomUpMergeSort {

    public static void sort(int[] data)
    {
        for(int width = 1; width < data.length; width *= 2)
        {
            int start_index = 0;
            while(start_index < data.length)
            {
                final int mid_index = start_index + width;
                final int end_index = mid_index + width;
                merge(data, start_index, mid_index, end_index);
                start_index = end_index;
            }
        }
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
        test(BotomUpMergeSort::sort);
    }
}
