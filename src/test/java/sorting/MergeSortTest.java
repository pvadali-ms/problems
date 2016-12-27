package sorting;

import org.junit.Test;

/**
 * Created by PV029500 on 11/28/2016.
 */
public class MergeSortTest {

    @Test
    public void test() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{8, 9, 1, 3, 5, 7, 8};
        mergeSort.mergeSort(arr);
        System.out.println(arr);
    }

}