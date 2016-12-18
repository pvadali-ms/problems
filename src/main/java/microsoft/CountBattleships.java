package microsoft;

/**
 * Created by PV029500 on 12/11/2016.
 */
public class CountBattleships {

    public int countBattleships(char[][] board) {

        int count = 0;
        if (board.length == 0) return 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (((j > 0 && board[i][j - 1] == '.') || j == 0)
                        && (((i > 0 && board[i - 1][j] == '.') || i == 0)) && board[i][j] == 'X') count++;
            }
        }

        return count;
    }
}
