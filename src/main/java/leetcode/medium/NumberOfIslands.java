package leetcode.medium;

/**
 * Created by PV029500 on 9/22/2016.
 */
public class NumberOfIslands {

    public int numOfIslands(char[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    run_DFS(i, j, grid);
                    num++;
                }
            }
        }
        return num;
    }

    public void run_DFS(int i, int j, char[][]grid) {
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        run_DFS(i + 1, j, grid);
        run_DFS(i, j + 1, grid);
        run_DFS(i - 1, j, grid);
        run_DFS(i, j - 1, grid);
    }
}
