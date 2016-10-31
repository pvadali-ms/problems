package leetcode.utility;

/**
 * Created by PV029500 on 10/23/2016.
 */
public class SwapNumbersArray {

    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
