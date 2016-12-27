package sorting;

/**
 * Created by PV029500 on 11/28/2016.
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    public void quickSortHelper(int[] nums, int p, int r) {

        if (p < r) {
            int q = (p + r) / 2;
            swap(nums, q, r);
            int j = p - 1;
            for (int i = p; i <= r - 1; i++) {
                if (nums[i] < nums[r]) {
                    swap(nums, j + 1, i);
                    j++;
                }
            }
            swap(nums, j + 1, r);
            quickSortHelper(nums, p, q - 1);
            quickSortHelper(nums, q + 1, r);
        }
    }

    public void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
