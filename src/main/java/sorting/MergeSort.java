package sorting;

import java.util.Arrays;

/**
 * Created by PV029500 on 11/28/2016.
 */
public class MergeSort {

    public void mergeSort(int[] nums) {
        mergeSortHelper(nums, 0, nums.length - 1);
    }

    public void mergeSortHelper(int[] nums, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSortHelper(nums, p, q);
            mergeSortHelper(nums, q + 1, r);
            //the left and right arrays can be avoided by declaring a helper array huge enough as the input array
            //http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html - example
            int[] left = Arrays.copyOfRange(nums, p, q + 1);
            int[] right = Arrays.copyOfRange(nums, q + 1, r + 1);
            int k = p;
            for (int i = 0, j = 0; k < r - p + 1; k++) {
                if (i < left.length && j < right.length && left[i] < right[j]) {
                    nums[k] = left[i++];
                } else if (j < right.length) {
                    nums[k] = right[j++];
                } else if (i < left.length) {
                    nums[k] = left[i++];
                }
            }
        }
    }
}
