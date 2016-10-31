package topics.arrays;

/**
 * Created by PV029500 on 10/23/2016.
 */
/*
    find the begin by iterating and checking only if target > nums[mid]
    write another loop with mid as (low + high) / 2 + 1 as it is guaranteed that there is nothing less than target on the right side
    decrease high on the right side in second loop to reach the end of the target
 */
public class SearchInRotatedArray {
    public int[] searchRange(int[] nums, int target) {

        int eBegin = -1, eEnd = -1;
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (target > nums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        if (nums[low] != target) return new int[]{eBegin, eEnd};

        eBegin = low;
        high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2 + 1;
            if (target < nums[mid])
                high = mid - 1;
            else
                low = mid;
        }
        eEnd = low;
        return new int[]{eBegin, eEnd};
    }

}
