package sorting;

import static sorting.SortTest.test;

public class CountSort {

    static final int MAX_VALUE = 20;
    public static void main(String... strings)
    {
        test(CountSort::sort);
    }
    public static void sort(int[] data) {
        /** assume data range from 0 to 20 **/

        int [] count = new int[MAX_VALUE+1]; //default all values are 0 meeting initialization need

        //initialize
        for(int value: data) //O(N)
            count[value] += 1; // mapping value to index

        int current_index = 0;

        //for all values in domain traversing in order
        for(int value=0; value <= MAX_VALUE; value++) { // O(N * K) where K is number of valid values allowed in domain
            int index = value;

            if( count[index] == 0 ) continue; //this value from input range is not in data to sort

            int temp = count[index];
            while(temp>0)
            {
                data[current_index] = value;
                current_index += 1;
                temp -= 1;
            }
        }

    }
}
