package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PV029500 on 7/25/2017.
 */
public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        int max = 1;
        List<Integer[]> pairsListBeginTime = new ArrayList<Integer[]>();
        List<Integer[]> pairsListEndTime = new ArrayList<Integer[]>();
        Map<Key, Integer> resultMap = new HashMap<Key, Integer>();
        for (int[] pair : pairs) {
            pairsListBeginTime.add(new Integer[]{pair[0], pair[1]});
            pairsListEndTime.add(new Integer[]{pair[0], pair[1]});
            resultMap.put(new Key(pair[0], pair[1]), 1);
        }
        Collections.sort(pairsListEndTime, new Comparator<Integer[]>() {
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        Collections.sort(pairsListBeginTime, new Comparator<Integer[]>() {
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });
        for (int i = pairsListBeginTime.size() - 1; i >= 0; i--) {
            Integer[] curr = pairsListBeginTime.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (pairsListEndTime.get(j)[1] < curr[0]) {
                    max = Math.max(max, resultMap.get(new Key(curr[0], curr[1])) + 1);
                    resultMap.put(new Key(pairsListEndTime.get(j)[0], pairsListEndTime.get(j)[1]),
                            Math.max(resultMap.get(new Key(pairsListEndTime.get(j)[0], pairsListEndTime.get(j)[1])),
                                    resultMap.get(new Key(curr[0], curr[1])) + 1));
                }
            }
        }
        return max;
    }

    class Key {
        private final int val1;
        private final int val2;

        public Key(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Key)) {
                return false;
            }

            Key otherKey = (Key) object;
            return this.val1 == otherKey.val1 && this.val2 == otherKey.val2;
        }

        @Override
        public int hashCode() {
            int result = 17; // any prime number
            result = 31 * result + Integer.valueOf(this.val1).hashCode();
            result = 31 * result + Integer.valueOf(this.val2).hashCode();
            return result;
        }
    }
}
