package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by PV029500 on 5/26/2017.
 */
public class LHSTest {

    @Test
    public void LHStest() {
        LHS lhs = new LHS();
        int[] input = new int[]{1,3,2,2,5,2,3,7};
        System.out.println(lhs.findLHS(input));
    }
}