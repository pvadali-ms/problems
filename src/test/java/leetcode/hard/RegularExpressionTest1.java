package leetcode.hard;

import org.junit.Test;

/**
 * Created by PV029500 on 9/10/2016.
 */
public class RegularExpressionTest1 {

    @Test
    public void testIsMatch() throws Exception {
        RegularExpressionMatching1 r = new RegularExpressionMatching1();

        System.out.println(r.isMatch("a", "aa*"));

    }
}