package com.ds.sorting;

import static com.ds.sorting.SortTest.test;

public class RadixSort {
    public static void main(String... strings)
    {
        test(RadixSort::sort);
    }
    public static void sort(int[] data) {

        if (data.length <= 1)
            return;

        int max_value = data[0];
        for(int elem: data)
            if(max_value < elem)
                max_value = elem;

        int bit_mask=1;
        while(bit_mask <= max_value) {
            int zero_bit[] = new int[data.length], zero_index = 0;
            int one_bit[] = new int[data.length], one_index = 0;

            for (int elem : data)
            {
                int bit = elem & bit_mask;
                if (bit == 0)
                {
                    zero_bit[zero_index] = elem;
                    zero_index++;
                }
                else
                {
                    one_bit[one_index] = elem;
                    one_index++;
                }
            }

            int index = 0, data_index=0;
            while(index <zero_index)
            {
                data[data_index]= zero_bit[index];
                index++;
                data_index++;
            }

            index = 0;
            while(index <one_index)
            {
                data[data_index]= one_bit[index];
                index++;
                data_index++;
            }

            bit_mask = bit_mask << 1;
        }
    }
}
