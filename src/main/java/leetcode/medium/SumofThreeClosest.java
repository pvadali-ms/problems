package leetcode.medium;

import java.util.Arrays;

/**
 * Created by PV029500 on 10/22/2016.
 */
public class SumofThreeClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int first = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - first))
                    first = sum;
                if (sum > target) k--;
                else j++;
            }
        }
        return first;
    }
}
