package com.ds.searching;

import java.util.OptionalInt;

public class BinarySearch {

    static public OptionalInt search(int [] data, int search_key) {
        //Assume data is sorted
        int start_index = 0, end_index = data.length-1;
        while(start_index <= end_index)
        {
            int mid = start_index + (end_index - start_index)/2;

            if(data[mid] == search_key)
                return OptionalInt.of(mid);
            else if( data[mid] < search_key)
                start_index = mid + 1;
            else
                end_index = mid - 1;
        }

        return OptionalInt.empty();
    }
}
