package leetcode.medium;

import org.junit.Test;

import java.util.List;

/**
 * Created by PV029500 on 10/7/2016.
 */
public class SumToZeroThreeNumTest {

    @Test
    public void threeSumTest() {
        SumtoZeroThreeNum sumToZeroThreeNum = new SumtoZeroThreeNum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = sumToZeroThreeNum.threeSum(nums);

        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

}