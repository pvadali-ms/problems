package leetcode.hard;

import org.junit.Test;

/**
 * Created by PV029500 on 9/29/2016.
 */
public class TrappingRainWaterTest {

    @Test
    public void testTrap() throws Exception {
        TrappingRainWater trappingRainWater = new TrappingRainWater();

        int[] arr = new int[]{0, 0, 0};

        System.out.println(trappingRainWater.trap(arr));
    }
}