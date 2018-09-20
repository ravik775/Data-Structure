package com.ds.sorting;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SortTest {

    private static Logger log = Logger.getLogger(SortTest.class.getName());

    @FunctionalInterface
    public interface SortAlgo
    {
        void sort(int [] data);
    }

    public static void test(SortAlgo algorithm)
    {
        test_steps(algorithm,  new int[] {4,5,2,1}, new int[]{1, 2, 4, 5});
        test_steps(algorithm,  new int[] {1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        test_steps(algorithm,  new int[] {}, new int[]{});
        test_steps(algorithm,  new int[] {4, 3, 2, 1}, new int[]{1, 2, 3, 4});
    }

    private static void test_steps(SortAlgo algorithm, int [] test_data, int [] expected)
    {
        log.log(Level.INFO, "Testing for data set {0}", Arrays.toString(test_data));
        algorithm.sort(test_data);
        log.log(Level.INFO, "Verifying the result");
        if(Arrays.equals(expected, test_data) == false)
            throw new AssertionError("Data not sorted");
    }

}
