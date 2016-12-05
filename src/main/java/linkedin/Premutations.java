package linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PV029500 on 11/26/2016.
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Premutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        return permute(nums, result, new ArrayList<Integer>());
    }

    public List<List<Integer>> permute(int[] nums, List<List<Integer>> result, List<Integer> curr) {

        if (curr.size() == nums.length) {
            result.add(new ArrayList<Integer>(curr));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!curr.contains(nums[i])) {
                curr.add(nums[i]);
                permute(nums, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
        return result;
    }

    //use a boolean array for lookup
    public List<List<Integer>> permuteVersion2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        return permute(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
    }

    public List<List<Integer>> permute(int[] nums, List<List<Integer>> result, List<Integer> curr, boolean used[]) {

        if (curr.size() == nums.length) {
            result.add(new ArrayList<Integer>(curr));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
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
