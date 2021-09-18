package leetcode.medium;

/**
 * Created by PV029500 on 10/20/2016.
 */
public class MaxProductSubArray {

    public int maxProduct(int[] nums) {

        int max = nums[0], result = max, min = max;
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (result < max) {
                result = max;
            }
        }
        return result;
    }

}
