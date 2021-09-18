package linkedin;

/**
 * Created by PV029500 on 11/27/2016.
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        int lastOne = nums[1], lastToLastOne = nums[0];
        int prevLast, prevLastToLast;
        for (int i = 2; i < nums.length; i++) {
            prevLast = lastOne;
            prevLastToLast = lastToLastOne;
            lastOne = Math.max(lastToLastOne + nums[i], lastOne);
            lastToLastOne = Math.max(prevLast, prevLastToLast);
        }
        return Math.max(lastOne, lastToLastOne);
    }
}
