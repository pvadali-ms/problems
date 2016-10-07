package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PV029500 on 10/7/2016.
 */
public class SumToZeroThreeNum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int size = nums.length, target;
        for (int k = 0; nums[k] <= 0; k++) {
            target = nums[k] * -1;
            for (int i = k + 1, j = size - 1; i < size && j > i;) {
                if (target == nums[i] + nums[j]) {
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                }
                while ((target < nums[i] + nums[j] && j > i)) {
                    j--;
                }
                while (target > nums[i] + nums[j] && i < j) {
                    i++;
                }

            }
        }

        return result;
    }

}
