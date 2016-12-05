package sorting;

/**
 * Created by PV029500 on 11/28/2016.
 */
public class HeapSort {

    int heapSize;
    public void heapSort(int[] nums) {
        heapSize = nums.length - 1;
        buildMinHeap(nums, nums.length - 1);
        for (int i = heapSize; i >= 0; i--) {
            swap(nums, 0, i);
            heapSize--;
            minHeapify(nums, 0);
        }
    }

    public void buildMinHeap(int[] nums, int n) {
        for (int i = n / 2; i >= 0; i--) {
            minHeapify(nums, i);
        }
    }

    public void minHeapify(int[] nums, int i) {
        int child1 = 2 * i;
        int child2 = child1 + 1;
        int tmp = i;
        if (child1 <= heapSize && nums[child1] > nums[i]) i = child1;
        if (child2 <= heapSize && nums[child2] > nums[i]) i = child2;
        if (tmp != i) {
            swap(nums, tmp, i);
            minHeapify(nums, i);
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
