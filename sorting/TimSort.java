package sorting;

import static sorting.SortTest.test;

public class TimSort {
    final static int WINDOW_SIZE=6;

    public static void main(String... strings)
    {
        test(TimSort::sort);
    }

    public static void sort(int[] data) {

        //Sorting data with in windows
        int startIndex = 0;
        while ( startIndex < data.length )
        {
            int endIndex= Math.min(data.length, startIndex+WINDOW_SIZE);
            _sort(data, startIndex, endIndex);
            startIndex=endIndex;
        }

        int midIndex = 0;
        while (midIndex < data.length)
        {
            int endIndex= Math.min(data.length, midIndex+WINDOW_SIZE);
            _merge(data, 0, midIndex, endIndex);
            midIndex=endIndex;
        }

    }

    private static void _merge(int [] data, int startIndex, int midIndex, int endIndex)
    {
        // end Index excluded
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

    private static void _sort(int [] data, int startIndex, int endIndex)
    {// end Index excluded

        for(int index_i=startIndex; index_i< endIndex; index_i++)
        {
            int data_elem = data[index_i];
            int index_j = index_i-1;
            while(index_j >= startIndex && data[index_j] > data_elem)
            {
                data[index_j+1] = data[index_j];
                index_j--;
            }
            index_j+=1;
            if(index_j !=index_i)
                data[index_j] = data_elem;
        }
    }
}
