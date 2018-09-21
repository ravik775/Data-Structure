package com.ds.sorting;

import static com.ds.sorting.SortTest.test;
import static com.ds.sorting.SortUtil.swap;

public class HeapSort {

    public static void sort(int[] data)
    {
        heapify(data, data.length-1); // O(n long)
        int max_index=data.length-1;
        while(max_index>0) //o(n LOG n)
        {
            swap(data, 0, max_index); //O(Log n)
            max_index--;
            push_down(data, 0, max_index);
        }
    }

    private static int get_min_index(int[] array, int index1, int index2)
    {
        /** Assume index1 and index2 are valid**/
        return array[index1]>array[index2]? index1:index2;
    }

    private static void heapify(int [] data, int max_index)
    {
        /** Max Heap **/
        int current_index = max_index;
        while(current_index > 0)
        {
            int min_index = find_min_node(data, current_index, max_index);
            if(min_index != current_index)
            {
                swap(data, current_index, min_index);
                push_down(data, min_index,max_index);
            }
            current_index-=2;
        }

    }

    private static int find_min_node(int []data, int index, int max_index)
    {
        int parent_index = (index - 1) / 2;
        int child_left_index = parent_index*2+1;
        int child_right_index = child_left_index+1;
        int min_index = parent_index;

        if (child_left_index<=max_index)
            min_index = get_min_index(data, parent_index, child_left_index);

        if (child_right_index<=max_index)
            min_index =  get_min_index(data, min_index, child_right_index);

        return min_index;
    }

    private static void push_down(int []data, int start_index, int max_index)
    {
        while(start_index <= max_index)
        {
            int min_index = find_min_node(data, start_index, max_index);
            if(min_index != start_index)
            {
                swap(data, start_index, min_index);
                start_index = min_index;
            }
            else
                break;
        }
    }
    public static void main(String... strings)
    {
        test(InsertionSort::sort);
    }
}
