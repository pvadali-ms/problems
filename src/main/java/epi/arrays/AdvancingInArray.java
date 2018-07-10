package epi.arrays;

/**
 * Created by PV029500 on 1/10/2017.
 */

/**
 * a[i] denotes the maximum steps you can advance from index i
 * return if it is possible to reach the end (or beyond)
 */
public class AdvancingInArray {

    public boolean advancingInArray(int[] steps) {
        int curr = 0;
        for (int i = 0; i <= curr && curr < steps.length - 1; i++) {
            curr = Math.max(curr, i + steps[i]);
        }
        return curr >= steps.length - 1;
    }
}