package leetcode.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by PV029500 on 5/26/2017.
 */
public class LHS {

    public int findLHS(int[] nums) {

        Map<Integer, Integer> m = new TreeMap<Integer, Integer>();

        for (int num : nums) {
            if (m.containsKey(num)) {
                m.put(num, m.get(num) + 1);
            } else {
                m.put(num, 1);
            }
        }

        int previousVal = -1;
        int currVal = -1;
        int previousKey = -1;
        int currKey = -1;
        int max = -1;
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (previousVal == -1) {
                previousVal = e.getValue();
                previousKey = e.getKey();
            } else {
                currVal = e.getValue();
                currKey = e.getKey();
            }

            if (currKey - previousKey == 1) {
                max = Math.max(max, currVal + previousVal);
            }
            if (currVal != -1){
                previousVal = currVal;
                previousKey = currKey;
            }
        }

        return max;
    }
}
