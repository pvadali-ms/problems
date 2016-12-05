package ibit.arrays;

import java.util.List;

/**
 * Created by PV029500 on 11/26/2016.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example:

 Given the array [-2,1,-3,4,-1,2,1,-5,4],

 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 For this problem, return the maximum sum.
 */

public class MaxSumContiguousSubArray {

    public int maxSubArray(final List<Integer> a) {
        if (a == null || a.size() < 1) return 0;
        int max = a.get(0), maxSofar = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            maxSofar = Math.max(a.get(i) + maxSofar, a.get(i));
            max = Math.max(max, maxSofar); //update max for each calculation of maxSofar
        }

        return max;
    }
}
