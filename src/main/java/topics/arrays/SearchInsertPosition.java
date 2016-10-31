package topics.arrays;

/**
 * Created by PV029500 on 10/23/2016.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        if (target <= nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        if (target == nums[nums.length - 1]) return nums.length - 1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid])
                return mid;
            if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
