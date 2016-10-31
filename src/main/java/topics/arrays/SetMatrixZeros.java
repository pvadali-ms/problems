package topics.arrays;

/**
 * Created by PV029500 on 10/24/2016.
 */
/*
    Set top of the row and column to zero if a zero is found where i > 0 & j > 0
    to track the first column, have a flag set to zero if there is a zero in the first column
    start filling it from nxn to 1x1 as filling it from top affects the flag checker matrix[i][0] && matrix[0][j]
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}
