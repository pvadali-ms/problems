package sorting;

import org.junit.Test;

/**
 * Created by PV029500 on 11/28/2016.
 */
public class QuickSortTest {

    @Test
    public void test() {
        int[] arr = new int[]{4, 3, 2, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr);
        System.out.println(arr[0]);
    }
}