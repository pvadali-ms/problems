package leetcode.medium;

/**
 * Created by PV029500 on 4/4/2017.
 */
public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int count = 0;
        for(int i = 0; i < M.length; i++)
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    count++;
                    DFS(M, i, j);
                }
            }
        return count;
    }

    private void DFS(int[][]M, int i, int j) {
        if (i < 0 || i > M.length - 1 || j < 0 || j > M[0].length - 1 || M[i][j] == 0)
            return;
        M[i][j] = 0;
        DFS(M, i - 1, j);
        DFS(M, i, j - 1);
        DFS(M, i + 1, j);
        DFS(M, i, j + 1);
//        return;
    }
}
