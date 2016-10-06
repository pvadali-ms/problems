package leetcode.medium;

import java.util.Set;

/**
 * Created by PV029500 on 10/6/2016.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean []concat = new boolean[s.length() + 1];

        concat[0] = true;

        for(int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if(concat[j] && wordDict.contains(s.substring(j, i))) {
                    concat[i] = true;
                    break;
                }
            }
        }

        return concat[s.length()];
    }

}
