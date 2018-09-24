package com.ds.sorting;

import static com.ds.sorting.SortTest.test;

public class ShellSort {
    public static void main(String... strings)
    {
        test(ShellSort::sort);
    }
    public static void sort(int[] data) {
        final int[] distances = {9, 7, 5, 3, 2, 1};

        for(int distance: distances)
        {
            for(int index=0; index < data.length; index+=distance )
            {
                int min_index = index;
                for(int index_j=index+distance; index_j< data.length; index_j+=distance)
                    if(data[min_index]> data[index_j])
                        min_index=index_j;
                if(min_index!=index)
                    SortUtil.swap(data, min_index, index);
            }
        }
    }

}
