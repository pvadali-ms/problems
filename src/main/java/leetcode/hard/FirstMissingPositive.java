package leetcode.hard;

/**
 * Created by PV029500 on 10/23/2016.
 */
public class FirstMissingPositive {

    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
                i++;
            } else if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return i + 1;
    }


}
