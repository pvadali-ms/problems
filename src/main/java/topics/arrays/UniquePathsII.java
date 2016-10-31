package topics.arrays;

/**
 * Created by PV029500 on 10/24/2016.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, columns = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) return 0;

        for (int i = 1; i < columns; i++)
            if (obstacleGrid[0][i] == 1 || obstacleGrid[0][i - 1] == -1) obstacleGrid[0][i] = -1;
            else obstacleGrid[0][i] = 1;

        for (int i = 1; i < rows; i++)
            if (obstacleGrid[i][0] == 1 || obstacleGrid[i - 1][0] == -1) obstacleGrid[i][0] = -1;
            else obstacleGrid[i][0] = 1;

        for (int i = 1; i < rows; i++)
            for(int j = 1; j < columns; j++)
                if ((obstacleGrid[i - 1][j] == -1 && obstacleGrid[i][j - 1] == -1) || obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = -1;

        if(obstacleGrid[0][0] == 0) obstacleGrid[0][0] = 1;

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < columns; j++)
                if (obstacleGrid[i][j] != -1) {
                    obstacleGrid[i][j] = (obstacleGrid[i - 1][j] == -1 ? 0 : obstacleGrid[i - 1][j]) +
                            (obstacleGrid[i][j - 1] == -1 ? 0 : obstacleGrid[i][j - 1]);
                }

        return obstacleGrid[rows - 1][columns - 1] != -1 ? obstacleGrid[rows - 1][columns - 1] : 0;
    }
}
