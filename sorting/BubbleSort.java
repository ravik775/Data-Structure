package sorting;
import static sorting.SortUtil.swap;
import static sorting.SortTest.test;
/*
Advantages:

    Easy to understand.
    Easy to implement.
    In-place, no external memory is needed.
    Performs greatly when the array is almost sorted.
    Disadvantages

    Very expensive, O(n2)in worst case and average case.
    It does more element assignments than its counterpart, insertion sort.

    Mainly used for Academics

*/
public class BubbleSort {

    public static void sort(int[] data)
    {
        for(int index1 = data.length-1; index1 > 0 ; index1--)
        {
            boolean swaped = false;
            for(int index2 = 0, nxt_index2=1; index2 < index1; index2=nxt_index2++)
                if(data[index2] > data[nxt_index2])
                {
                    swap(data, index2, nxt_index2);
                    swaped=true
                }
            if(!swaped) break
        }
    }

    public static void main(String... strings)
    {
        test(BubbleSort::sort);
    }
}
