package topics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PV029500 on 10/23/2016.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, new ArrayList<Integer>(), result, 0);
        return result;
    }

    public void combinationSumHelper(int[] nums, int target, List<Integer> resultSofar, List<List<Integer>> result, int begin) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(resultSofar));
            return;
        }
        for (int i = begin; i < nums.length && nums[i] <= target; i++) {
            if (i == begin || nums[i] != nums[i - 1]) {                         //this if condition is to guarantee unique results
                resultSofar.add(nums[i]);
                combinationSumHelper(nums, target - nums[i], resultSofar, result, i + 1);
                resultSofar.remove(resultSofar.size() - 1);
            }
        }
    }
}
