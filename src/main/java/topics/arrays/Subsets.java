package topics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PV029500 on 10/25/2016.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        return helper(new ArrayList<List<Integer>>(), nums, 0, new ArrayList<Integer>());
    }

    public List<List<Integer>> helper(List<List<Integer>> result, int[] nums, int start, List<Integer> curr) {
        result.add(new ArrayList<Integer>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(result, nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
        return result;
    }
}
