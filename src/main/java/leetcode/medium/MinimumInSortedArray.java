package leetcode.medium;

/**
 * Created by PV029500 on 10/20/2016.
 */
public class MinimumInSortedArray {

    public int findMin(int[] nums) {
        return min(nums, 0, nums.length - 1);
    }

    public int min(int[]nums, int low, int high) {
        if (low <= high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = (low + high) / 2;
            if (nums[low] > nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return min(nums, low, high);
    }
}
