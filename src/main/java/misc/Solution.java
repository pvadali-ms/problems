package misc;

import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int operations = scanner.nextInt();
        int[] updates = new int[3];
        int[] res = new int[length];
        for (int j = 0; j < operations; j++) {

            int start = scanner.nextInt() - 1;
            int end = scanner.nextInt() - 1;
            int value = scanner.nextInt();
            res[start] += value;
            Class in = Integer.class;
            if (end < length - 1)
                res[end + 1] -= value;


        }

        int sum = 0, max = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
            max = max > sum ? max : sum;
        }

        System.out.println(max);
    }

}