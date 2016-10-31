package leetcode.hard;

import org.junit.Test;

/**
 * Created by PV029500 on 10/23/2016.
 */
public class FirstMissingPositiveTest {

    @Test
    public void firstMissingPositive() {

        int[] arr = new int[]{3, 4, -1, 1};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(arr));

    }

}