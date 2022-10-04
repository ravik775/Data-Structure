package sorting;

import java.util.Arrays;
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
        test_steps(algorithm,  new int[] {4, 5, 4, 5}, new int[]{4, 4, 5, 5});
        test_steps(algorithm,  new int[] {4, 3, 5, 6, 9, 7, 8, 2, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        test_steps(algorithm,  new int[] {1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        test_steps(algorithm,  new int[] {}, new int[]{});
        test_steps(algorithm,  new int[] {4, 3, 2, 1}, new int[]{1, 2, 3, 4});
        test_steps(algorithm,  new int[] {0, 4, 3, 5, 6, 9, 7, 8, 2, 1, 4, 3, 5, 6, 0, 9, 7, 8, 2, 1},
                               new int[] {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9});

        test_steps(algorithm,  new int[] {1, 2, 2, 1, 3, 1, 2, 2, 1, 4, 1, 2, 2, 1, 3, 1, 2, 2, 1, 5},
                               new int[] {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 4, 5});

    }

    private static void test_steps(SortAlgo algorithm, int [] test_data, int [] expected)
    {
        log.log(Level.INFO, "Testing for data set {0}", Arrays.toString(test_data));
        algorithm.sort(test_data);
        log.log(Level.INFO, "Verifying the result {0} with expectation.", Arrays.toString(test_data));
        if(Arrays.equals(expected, test_data) == false)
            throw new AssertionError(String.format("Data not sorted, expected : %s and actual: %s.",
                        Arrays.toString(expected), Arrays.toString(test_data)));
    }

}
