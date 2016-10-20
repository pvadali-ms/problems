package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by k on 10/19/16.
 */
public class CombinationSumIII {


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        recurse(n, k, new ArrayList<Integer>(), result, 1);
        return result;
    }

    public void recurse(int n, int k, List<Integer> currList, List<List<Integer>> result, int start) {

        if(currList.size() == k && n == 0) {
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        if(currList.size() == k || start > n) return;
        for (int i = start; i < 10; i++) {
            currList.add(i);
            recurse(n - i, k, currList, result, start + 1);
            currList.remove(currList.size() - 1);
        }
    }
}
