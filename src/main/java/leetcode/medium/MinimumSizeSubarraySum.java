package leetcode.medium;

/**
 * Created by k on 10/19/16.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {

        int min = nums.length + 1;

        int start = 0, sum = 0;
        int i;
        for (i = 0; i < nums.length; ) {
            if (sum >= s) {
                sum -= nums[start];
                start++;
                min = Math.min(min, i - start + 1);
            } else {
                sum += nums[i];
                i++;
            }
        }

        while (sum >= s) {
            sum -= nums[start];
            start++;
            min = Math.min(min, i - start + 1);
        }

        return min == nums.length + 1 ? 0 : min;
    }
}
