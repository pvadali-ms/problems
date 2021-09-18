package leetcode.medium;

public class FlipMatrix {

    public int matrixScore(int[][] input) {
        int rows = input.length;
        int cols = input[0].length;
        transformRow(input);
        transformCol(input);
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            int partialSum = 0;
            int count = 0;
            for (int j = cols - 1; j >= 0; j--) {
                partialSum += ((int) Math.pow(2, count++)) * input[i][j];
            }
            sum += partialSum;
        }
        return sum;
    }

    private void transformRow(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i][0] == 0) {
                for (int j = 0; j < input[0].length; j++)
                    if (input[i][j] == 0)
                        input[i][j] = 1;
                    else
                        input[i][j] = 0;
            }
        }
    }

    private void transformCol(int[][] input) {
        for (int j = 1; j < input[0].length; j++) {
            int ones = 0;
            for (int[] anInput : input) {
                if (anInput[j] == 1)
                    ones++;
            }
            if (ones <= input.length / 2) {
                for (int[] anInput : input) {
                    if (anInput[j] == 1)
                        anInput[j] = 0;
                    else
                        anInput[j] = 1;
                }
            }
        }
    }
}
