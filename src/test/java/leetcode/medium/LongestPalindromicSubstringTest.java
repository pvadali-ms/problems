package leetcode.medium;

import org.junit.Test;

/**
 * Created by PV029500 on 9/12/2016.
 */
public class LongestPalindromicSubstringTest {

    @Test
    public void testLongestPalindrome() throws Exception {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        LongestPalindromicSubstring.DynamicProgram d = l.new DynamicProgram();
        System.out.println(d.longestPalindrome("abcba"));
    }
}