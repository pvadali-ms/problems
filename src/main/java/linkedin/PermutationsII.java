package linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PV029500 on 11/26/2016.
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        return permute(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
    }

    public List<List<Integer>> permute(int[] nums, List<List<Integer>> result, List<Integer> curr, boolean[] used) {

        if (curr.size() == nums.length) {
            result.add(new ArrayList<Integer>(curr));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                used[i] = true;
                curr.add(nums[i]);
                permute(nums, result, curr, used);
                used[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
        return result;
    }
}
