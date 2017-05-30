package leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by PV029500 on 4/26/2017.
 */
public class RemoveBoxesTest {

    @Test
    public void test() {
        RemoveBoxes removeBoxes = new RemoveBoxes();
        int[] boxes = new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1};
//        int[] boxes = new int[]{3,8,8,5,5,3,9,2,4,4,6,5,8,4,8,6,9,6,2,8,6,4,1,9,5,3,10,5,3,3,9,8,8,6,5,3,7,4,9,6,3,9,4,3,5,10,7,6,10,7};
//        int[] boxes = new int[]{1, 3, 3};
        System.out.println(removeBoxes.removeBoxes(boxes));
    }

    @Test
    public void fibTest() {
        System.out.println(fib(50));
    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}