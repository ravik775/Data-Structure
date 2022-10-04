package sorting;

import static sorting.SortTest.test;

public class NaturalMergeSort {
    public static void sort(int[] data)
    {
        divide(data, 0, data.length);
    }

    private static void divide(int[] data, int startIndex, int endIndex)
    {
        /** start Inclusive and end Exclusive**/
        if( (endIndex-startIndex) <= 1)
            return; // for 0 and 1 element sort is not needed

        int mid_index = startIndex+1;

        while(mid_index < endIndex && data[mid_index] >= data[mid_index-1])
            mid_index++;

        divide(data, mid_index, endIndex);
        merge(data, startIndex, mid_index, endIndex);
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
        test(NaturalMergeSort::sort);
    }
}
