package epi.arrays;

import leetcode.utility.SwapNumbersArray;

/**
 * Created by PV029500 on 1/16/2017.
 */

/**
 * This solution might not be accurate enough. Has to be revisited
 */
public class NextPermutation {

    public int[] nextPermutation(int[] arr) {
        int breakPoint = 0;
        int i = arr.length - 1;
        int[] res = new int[]{};
        for (; i > 0 && arr[i] < arr[i - 1]; i--) ;

        if (i != 0) {
            int newIndex = findNextLargest(arr, i, arr[i]);
            SwapNumbersArray.swap(arr, newIndex, i);
            reverseArray(arr, i + 1, arr.length - 1);
        }
        return res;
    }

    public int findNextLargest(int[] arr, int pos, int prev) {
        int min = arr[pos + 1];
        int newIndex = 0;
        for (int i = pos; i < arr.length; i++) {
            if (arr[i] > prev) {
                int temp = min;
                min = Math.min(min, arr[i]);
                if (temp != min)
                    newIndex = min;
            }
        }
        return newIndex;
    }

    public void reverseArray(int[] arr, int begin, int end) {
        for (int i = begin, j = end; i <= j; i++, j--) {
            SwapNumbersArray.swap(arr, i, j);
        }
    }
}
