package com.ds.sorting;

import java.util.Arrays;
import java.util.OptionalInt;

import static com.ds.sorting.SortTest.test;

public class RadixSort {
    public static void main(String... strings)
    {
        test(RadixSort::sort);
    }

    private static int findMax(int data[])
    { //expect data to be of length greater than zero.
        int max_value = data[0];
        for(int elem: data)
            if(max_value < elem)
                max_value = elem;

        return max_value;
    }
    public static void sort(int[] data) {

        if (data.length <= 1)
            return;

        int max_value = findMax(data);

        int bit_mask = 1;
        while (bit_mask <= max_value) {
            int zero_bit[] = new int[data.length], zero_index = 0;
            int one_bit[] = new int[data.length], one_index = 0;

            for (int elem : data) {
                int bit = elem & bit_mask;
                if (bit == 0) {
                    zero_bit[zero_index] = elem;
                    zero_index++;
                } else {
                    one_bit[one_index] = elem;
                    one_index++;
                }
            }
            
            System.arraycopy(zero_bit, 0, data, 0, zero_index);
            System.arraycopy(one_bit, 0, data, zero_index, one_index);

            bit_mask = bit_mask << 1;
        }
    }
}
