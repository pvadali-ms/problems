package leetcode.utility;

/**
 * Created by PV029500 on 10/23/2016.
 */


public class MaxSubArrayNoIndex {

    /*
        in linear time
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            max = Math.max(sum, max);
        }

        return max;
    }

    /*
        in nlogn - refer balaji notes
     */
    public int[] maxSubArr(int[] nums, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            int[] leftResult = maxSubArr(nums, begin, mid);
            int[] rightResult = maxSubArr(nums, mid + 1, end);
            int leftMax = nums[mid], leftSum = nums[mid], leftIndex = mid;

            for(int i = mid - 1; i >= begin; i--) {
                leftSum = leftSum + nums[i];
                if (leftSum > leftMax) {
                    leftIndex = i;
                    leftMax = leftSum;
                }
            }

            int rightMax = nums[mid + 1], rightSum = nums[mid + 1], rightIndex = mid + 1;
            for (int i = mid + 2; i <= end; i++) {
                rightSum = rightSum + nums[i];
                if (rightSum > rightMax) {
                    rightMax = rightSum;
                    rightIndex = i;
                }
            }
            int max = leftMax + rightMax;
            if (leftMax > max) {
                return new int[]{leftIndex, leftResult[1], leftSum};
            } else if (rightMax > max) {
                return new int[]{rightResult[1], rightIndex, rightSum};
            } else {
                return new int[]{leftIndex, rightIndex, max};
            }
        } else if (begin == end) {
            return new int[]{begin, end, nums[begin]};
        } else {
            return new int[]{begin, begin - 1, 0};
        }
    }

}
