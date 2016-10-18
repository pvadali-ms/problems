package leetcode.medium;

/**
 * Created by PV029500 on 10/14/2016.
 */
public class PartitionEqualSubset {
    public boolean canPartition(int[] nums) {
        int l = nums.length;
        boolean[][]dp = new boolean[l][l];

        for(int i = 0; i < l; i++) {
            for (int j = 0; j < i; j++) {

            }
        }
        return dp[l - 1][l - 1];
    }
}
