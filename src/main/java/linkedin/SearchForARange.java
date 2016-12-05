package linkedin;

/**
 * Created by PV029500 on 11/28/2016.
 */
public class SearchForARange {

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
