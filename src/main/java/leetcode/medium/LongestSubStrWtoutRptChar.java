package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PV029500 on 8/12/2016.
 */
public class LongestSubStrWtoutRptChar {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) return 0;
        int begin = 0, end = 0, max = 0, position = 0, lastRep = -1;

        Map<Character, Integer> m = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            if (m.containsKey(c)) {
                max = Math.max(max, end - begin + 1);
                lastRep = Math.max(m.get(c) + 1, lastRep);
                begin = lastRep;
                end = position;
                m.put(c, position);
            } else {
                m.put(c, position);
                end = position;
            }
            position++;
        }
        return Math.max(max, end - begin + 1);
    }
}
