package sorting;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;

import static sorting.SortTest.test;
import static sorting.SortUtil.swap;

public class SelectionSort {
    public static void sort(int[] data)
    {
        for(int index1 = 0; index1 < data.length ; index1++)
        {
            int min_index = index1;
            for(int index2=min_index+1; index2 < data.length; index2++)
                if(data[min_index] > data[index2])
                    min_index = index2;
             swap(data, index1, min_index);
        }
    }

    public static void main(String... strings)
    {

        test(SelectionSort::sort);


    }
}
