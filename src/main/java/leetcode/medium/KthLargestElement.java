package leetcode.medium;

import java.util.Arrays;

/**
 * Created by PV029500 on 10/8/2016.
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        int median;
        int begin = 0, end = nums.length - 1, result = -1;
        while(result != k - 1 && begin <= end) {
            int [] temp = new int[end - begin + 1];
            int var = begin, p = 0;
            while (var <= end) {
                temp[p++] = nums[var++];
            }
            median = select(temp, nums);
            swap(nums, median, end);
            result = partition(nums, begin, end);

            if (result == k - 1)
                return nums[result];
            else if (result < k - 1) {
                begin = result + 1;
            } else {
                end = result - 1;
            }
        }
        return 0;
    }

    public int partition(int[] nums, int begin, int end) {
        int x = nums[end];
        int i = begin - 1;
        for (int j = begin; j <= end - 1; j++) {
            if (nums[j] > x) {
                i += 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return i + 1;
    }

    public int select(int[] arr, int[] nums) {
        if(arr.length == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (arr[0] == nums[i]) return i;
            }
        }
        int[] temp = new int[arr.length / 5 + (arr.length % 5 == 0 ? 0 : 1)];
        int count = 0;
        for (int j = 0; j < arr.length/5; j++) {
            Arrays.sort(arr, count, count + 5);
            count += 5;
            temp[j] = arr[(2 * count - 5) / 2];
        }

        if (arr.length % 5 != 0) {
            Arrays.sort(arr, count, arr.length);
            temp[arr.length / 5] = arr[(count + arr.length - 1) / 2];
        }

        return select(temp, nums);
    }

    public void swap(int[] nums, int from, int to) {
        if (from != to) {
            nums[from] = nums[to] ^ nums[from];
            nums[to] = nums[to] ^ nums[from];
            nums[from] = nums[to] ^ nums[from];
        }
    }

}
