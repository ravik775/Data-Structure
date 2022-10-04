package sorting;

import static sorting.SortTest.test;

public class QuickSort {
    public static void main(String... strings)
    {
        test(QuickSort::sort);
    }
    public static void sort(int[] data) {
        quick_sort(data, 0, data.length);
    }

    private static int partition(int[] data, int start_index, int end_index) {

        int index_i = start_index;
        int index_j = end_index -1;
        while(index_i < index_j)
        {
            while(index_i < index_j && data[index_i] <= data[index_j])
                index_i++;

            while(index_i < index_j && data[index_i] < data[index_j])
                index_j--;

            if(index_i < index_j)
                SortUtil.swap(data, index_i, index_j);
        }
        return index_i;
    }

    private static void quick_sort(int[] data, int start_index, int end_index) {
        // end index excluded
        if( end_index - start_index <= 1)
            return;

        int partition_index = partition(data, start_index, end_index);
        quick_sort(data, 0, partition_index);
        quick_sort(data, partition_index+1, end_index);
    }

}
