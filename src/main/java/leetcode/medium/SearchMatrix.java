package leetcode.medium;

/**
 * Created by PV029500 on 10/6/2016.
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length - 1;
        int row = 0;
        if (matrix[0][0] > target || matrix[matrix.length - 1][col] < target) return false;

        while (row < matrix.length && col >= 0) {
            if (target > matrix[row][col]) {
                row++;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                return true;
            }
        }

        return false;
    }
}
