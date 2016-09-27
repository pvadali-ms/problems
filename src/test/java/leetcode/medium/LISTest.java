package leetcode.medium;

import org.junit.Test;

/**
 * Created by PV029500 on 8/14/2016.
 */
public class LISTest {

    @Test
    public void testLengthOfLIS() throws Exception {
        LIS lis = new LIS();
        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lis.lengthOfLIS(arr));
    }
}