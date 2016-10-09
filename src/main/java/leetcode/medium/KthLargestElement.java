package leetcode.medium;

import java.util.Arrays;

/**
 * Created by PV029500 on 10/8/2016.
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        int median = k + 1;
        int begin = 0, end = nums.length - 1, result;
        while(median != k && begin < end) {
            median = runSelect(nums, begin, end);
            swap(nums, median, end);
            result = partition(nums, begin, end);
            if (result > k) {
                end = result - 1;
            } else if (result < k) {
                begin = result;
                k = k - result;
            } else {
                return nums[k];
            }
        }
        return 0;
    }

    public int partition(int[] nums, int begin, int end) {
        int x = nums[end];
        int i = begin - 1;
        for (int j = begin; j < end - 1; j++) {
            if (nums[j] < x) {
                i += 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return i + 1;
    }
    public int runSelect(int[] nums, int begin, int end) {
        int k = roundCeil(end - begin, 5);
        int arr[] = new int[k == 0 ? 1 : k];
        int count = 0, i;
        for (i = begin; i + 5 < end; i += 5) {
            Arrays.sort(nums, i, i + 5);
            arr[count] = roundCeil((2 * i + 5), 2);
            count++;
        }
        if (i > end) i -= 5;
        Arrays.sort(nums, i, end + 1);
        arr[count] = roundCeil((i + end), 2);
        return arr[roundFloor(arr.length, 2)];
    }

    public void swap(int[] nums, int from, int to) {
        if (from != to) {
            nums[from] = nums[to] ^ nums[from];
            nums[to] = nums[to] ^ nums[from];
            nums[from] = nums[to] ^ nums[from];
        }
    }

    public int roundCeil(int a, int b) {
        return (a / b) + (a % b == 0 ? 0 : 1);
    }

    public int roundFloor(int a, int b) {
        return (a / b);
    }
}
