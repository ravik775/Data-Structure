package com.ds.sorting;

import static com.ds.sorting.SortTest.test;
import static com.ds.sorting.SortUtil.swap;

public class HeapSort {

    public static void sort(int[] data)
    {
        heapify(data, data.length - 1); // O(n long)
        int max_index=data.length-1;
        while(max_index>0) //o(n LOG n)
        {
            swap(data, 0, max_index); //O(Log n)
            max_index--;
            push_down(data, 0, max_index);
        }
    }

    private static int get_max_index(int[] array, int index1, int index2)
    {
        /** Assume index1 and index2 are valid**/
        return array[index1] > array[index2]? index1 : index2;
    }

    private static void heapify(int [] data, int max_index)
    {
        /** Max Heap **/
        int current_index = max_index;
        while(current_index >= 0)
        {
            int max_node_index = find_max_node(data, current_index, max_index);
            if(max_node_index != current_index)
            {
                swap(data, current_index, max_node_index);
                push_down(data, max_node_index, max_index);
            }
            current_index -= 1;
        }

    }

    private static int find_max_node(int []data, int parent_index, int max_index)
    {
        int child_left_index = parent_index*2+1;
        int child_right_index = child_left_index+1;
        int max_node_index = parent_index;

        if (child_left_index <= max_index)
            max_node_index = get_max_index(data, parent_index, child_left_index);

        if (child_right_index <= max_index)
            max_node_index =  get_max_index(data, max_node_index, child_right_index);

        return max_node_index;
    }

    private static void push_down(int []data, int start_index, int max_index)
    {
        while(start_index <= max_index)
        {
            int max_node_index = find_max_node(data, start_index, max_index);

            if(max_node_index == start_index)   break;

            swap(data, start_index, max_node_index);

            start_index = max_node_index;
        }
    }
    public static void main(String... strings)
    {
        test(HeapSort::sort);
    }
}
