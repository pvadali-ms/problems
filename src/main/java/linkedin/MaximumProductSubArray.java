package linkedin;

/**
 * Created by PV029500 on 11/27/2016.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {

        int max = nums[0], result = max, min = max;

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            result = Math.max(max, result);
        }

        return result;
    }
}
