package epi.arrays;

/**
 * Created by PV029500 on 1/13/2017.
 */

import leetcode.utility.SwapNumbersArray;

/**
 * applying permutation <2, 0, 1, 3> against <a, b, c, d> should give:
 * <b, c, a, d>. We can use an empty array, for each perm 0..n - 1, empty[perm[i]] = arr[i]
 * But this one uses extra space.
 * To do it in constant space, keep swapping elements to the respective indices, storing current value at new index in a temp
 * mark the perm index to negative by doing a perm[i] - perm.length
 * once everything is negative in perm, the cycles are complete and restore perm, adding perm.length
 */
public class ApplyPermutationAgainstArray {

    public int[] applyPermutations(int[] arr, int[] permutation) {

        for (int i = 0; i < arr.length; i++) {
            int next = i;
            while(permutation[next] >= 0) {
                SwapNumbersArray.swap(arr, i, permutation[next]);
                int temp = permutation[next];
                permutation[next] -= permutation.length;
                next = temp;
            }
        }

        //below loop is to restore the permutation array
        for (int i = 0; i < permutation.length; i++)
            permutation[i] += permutation.length;
        return arr;
    }
}
