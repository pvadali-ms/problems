package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PV029500 on 10/25/2016.
 */
public class FindDuplicatesPocketGems {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int temp;
        while (i < nums.length) {
            if (nums[i] == 0)
                i++;
            else if (nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
            else if (nums[nums[i] - 1] == nums[i] && i != nums[i] - 1) {
                temp = nums[i];
                nums[i] = 0;
                nums[temp - 1] = 0;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0)
                result.add(nums[j]);
        }
        return result;
    }

    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
