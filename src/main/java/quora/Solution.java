package quora;

import java.util.Scanner;

/**
 * Created by PV029500 on 2/7/2017.
 */

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sn = new Scanner(System.in);
        int size = sn.nextInt();
        int window = sn.nextInt();
        int[] arr = new int[size];
        int count = 0;
        while (sn.hasNext()) {
            arr[count++] = sn.nextInt();
        }
        upVotes(arr, window);
    }

    public static void upVotes(int[] arr, int window) {
        int finalInc = 0, finalDec = 0, currentInc = 1, currentDec = 1;
        for (int i = 0; i + window - 1 < arr.length; i++) {
            for (int j = i + 1; j <= i + window - 1; j++) {
                if (arr[j] > arr[j - 1]) {
                    currentInc += 1;
                    if (currentDec != 1) {
                        finalDec += (currentDec * (currentDec - 1)) / 2;
                        currentDec = 1;
                    }
                } else if (arr[j] < arr[j - 1]) {
                    currentDec += 1;
                    if (currentInc != 1) {
                        finalInc += (currentInc * (currentInc - 1)) / 2;
                        currentInc = 1;
                    }
                } else {
                    currentDec += 1;
                    currentInc += 1;
                }
            }
            if (currentDec != 1) {
                finalDec += (currentDec * (currentDec - 1)) / 2;
                currentDec = 1;
            }
            if (currentInc != 1) {
                finalInc += (currentInc * (currentInc - 1)) / 2;
                currentInc = 1;
            }
            System.out.println(finalInc - finalDec);
            finalInc = 0;
            finalDec = 0;
        }
    }
}
