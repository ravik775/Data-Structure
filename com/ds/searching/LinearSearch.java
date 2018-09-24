package com.ds.searching;

import java.util.OptionalInt;

public class LinearSearch {

    static public OptionalInt search(int [] data, int search_key)
    {
        // data need not be sorted
        for(int index = 0 ; index < data.length ; index++)
            if( data[index] == search_key)
                return OptionalInt.of(index);
        return OptionalInt.empty();
    }
}
