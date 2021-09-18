package linkedin;

import java.util.Arrays;

/**
 * Created by PV029500 on 11/27/2016.
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] result = Arrays.copyOf(nums, nums.length);
        for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
            nums[i] *= nums[i - 1];
            result[j] *= result[j + 1];
        }

        int first = result[1];
        int last = nums[nums.length - 2];

        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = result[i + 1] * nums[i - 1];
        }
        result[0] = first;
        result[nums.length - 1] = last;

        return result;
    }

    //best voted
    public int[] productExceptSelfBestVoted(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
