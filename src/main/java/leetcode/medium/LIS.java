package leetcode.medium;

import java.util.TreeMap;

/**
 * Created by PV029500 on 8/14/2016.
 */
public class LIS {
    public int lengthOfLIS(int[] nums) {

        int max = 0;
        Integer floorKey, ceilingKey;

        TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
        for (int i : nums) {
            if (!m.containsKey(i)) {
                floorKey = m.floorKey(i);
                ceilingKey = m.ceilingKey(i);
                if (floorKey != null)
                    m.put(i, m.get(floorKey) + 1);
                else
                    m.put(i, 1);
                if (ceilingKey != null && m.get(i) >= m.get(ceilingKey)) {
                    m.remove(ceilingKey);
                }
            }
            max = Math.max(max, m.get(i));
        }
        return max;
    }
}
