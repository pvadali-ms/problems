package tripleByte;

/**
 * Created by PV029500 on 2/7/2017.
 */
public class TicTacToeAI {

    public void fillPosition(TicTacToe ticTacToe) {
        char[][] board = ticTacToe.board;
        int dimension = TicTacToe.dimension;
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                    return;
                }
    }
}
