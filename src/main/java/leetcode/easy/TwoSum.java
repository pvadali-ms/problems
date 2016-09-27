package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PV029500 on 7/25/2016.
 */
public class TwoSum {
    public class Solution{
        public int[] twoSum (int[] nums, int target) {
            int[] result = new int[2];
            Map<Integer, Integer> m = new HashMap<Integer, Integer>();
            for(int i = 0; i < nums.length; i++) {
                if (m.containsKey(target - nums[i])) {
                    result[0] = m.get(target - nums[i]);
                    result[1] = i;
                    return result;
                } else {
                    m.put(nums[i], i);
                }
            }
            return null;
        }
    }
}
