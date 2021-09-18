package leetcode.hard;

import java.util.Scanner;

/**
 * Created by PV029500 on 4/26/2017.
 */
class RemoveBoxes {

    int max;

    int removeBoxes(int[] boxes) {
        removeBoxes(boxes, 0);
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        return max;
    }

    private int removeBoxes(int[] boxes, int currSum) {
        if (boxes.length == 0) {
            max = Math.max(currSum, max);
        }
        for (int i = 0; i < boxes.length; ) {
            int begin = i;
            int count = 1;
            while (i + 1 < boxes.length && boxes[i] == boxes[i + 1]) {
                i++;
                count++;
            }
            i++;
            int arr[] = new int[begin + boxes.length - i];
            int index = 0;
            for (int j = 0; j < begin; j++) {
                arr[index++] = boxes[j];
            }
            System.out.print("[");
            String currRes = "";
            String delim = "";
            for (int j = i; j < boxes.length; j++) {
                arr[index++] = boxes[j];
                currRes += delim + boxes[j];
                delim = " ,";
            }
            if (currRes.length() > 0)
                System.out.println("Calculating for:" + currRes + "]");
            removeBoxes(arr, currSum + (count * count));
        }
        return currSum;
    }
}
