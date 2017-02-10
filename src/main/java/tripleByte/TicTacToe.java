package tripleByte;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by PV029500 on 2/7/2017.
 */
public class TicTacToe {

    public static int dimension = 3;
    public char[][] board;

    public TicTacToe() {
        board = new char[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            Arrays.fill(board[i], '-');
        }
    }

    public void addCharacter(char c, int row, int col) {
        board[row][col] = c;
    }

    public void printBoard() {
        for (int row = 0; row < dimension; row++) {
            String delimiter = "";
            for(int col = 0; col < dimension; col++) {
                System.out.print(delimiter + board[row][col]);
                delimiter = "|";
            }
            System.out.println("");
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < dimension; i++)
            for(int j = 0; j < dimension; j++)
                if (board[i][j] == '-')
                    return false;
        return true;
    }

    public static void main(String args[]) {
        TicTacToe ticTacToe = new TicTacToe();
        TicTacToeAI ai = new TicTacToeAI();
        Scanner scanner = new Scanner(System.in);
        boolean user = true;
        for(int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (user) {
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();
                    ticTacToe.addCharacter('X', row, col);
                    user = false;
                } else {
                    ai.fillPosition(ticTacToe);
                    user = true;
                }
                ticTacToe.printBoard();
                if (ticTacToe.isBoardFull()) {
                    return;
                }
            }
        }
    }
}
