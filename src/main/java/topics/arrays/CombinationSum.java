package topics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PV029500 on 10/23/2016.
 */
/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]


 */


public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, new ArrayList<Integer>(), 0, result);
        return result;
    }

    public void combinationSumHelper(int[] nums, int target, List<Integer> resultSofar, int index, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(resultSofar));
            return;
        }
        for(int i = index; i < nums.length && nums[i] <= target; i++) {
            resultSofar.add(nums[i]);
            combinationSumHelper(nums, target - nums[i], resultSofar, i, result);
            resultSofar.remove(resultSofar.size() - 1);
        }
    }
}
