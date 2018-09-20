package com.ds.sorting;

public class SortUtil {

    public static <T> void swap(int[] data, int index1, int index2)
    {
        var temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
