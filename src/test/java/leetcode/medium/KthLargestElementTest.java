package leetcode.medium;

import org.junit.Test;

/**
 * Created by PV029500 on 10/9/2016.
 */
public class KthLargestElementTest {

    @Test
    public void kthLargestSelect() {
        int[] arr = new int[]{-1, -8, 9, 1, 2, 6, 4, 3, 0};

        KthLargestElement kthLargestElement = new KthLargestElement();
        for(int k = 1; k < 10; k++) {
            System.out.println(kthLargestElement.findKthLargest(arr, k));
        }

    }


}