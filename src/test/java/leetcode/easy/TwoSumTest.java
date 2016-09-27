package leetcode.easy;


import org.junit.Test;

/**
 * Created by PV029500 on 7/25/2016.
 */
public class TwoSumTest {

    @Test
    public void testTwoSum() throws Exception {
        TwoSum t = new TwoSum();
        TwoSum.Solution s = t.new Solution();
        int[] nums = new int[]{1, 2, 4, 6};
        int[] result = s.twoSum(nums, 6);
        assert result[0] == 1;
        assert result[1] == 2;
    }
}