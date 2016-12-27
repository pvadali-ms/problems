package sorting;

import org.junit.Test;

/**
 * Created by PV029500 on 11/28/2016.
 */
public class HeapSortTest {

    @Test
    public void test() {
        HeapSort heapSort = new HeapSort();
        int[] arr = new int[]{1, 8, 2, 9};
        heapSort.heapSort(arr);
        System.out.println(arr);
    }
}