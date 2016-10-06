package leetcode.medium;

/**
 * Created by k on 10/5/16.
 */
public class RotateMatrix90Deg {

    public void rotate(int[][] matrix) {
        int x = matrix.length - 1;
        int tmp;

        for (int i = 0; i < (x + 1) / 2; i++) {
            for (int j = i; j < x - i; j++) {
                tmp = matrix[x - j][i];
                matrix[x - j][i] = matrix[x - i][x - j];
                matrix[x - i][x - j] = matrix[j][x - i];
                matrix[j][x - i] = matrix[i][j];
                matrix[i][j] = tmp;

            }

        }
    }
}
