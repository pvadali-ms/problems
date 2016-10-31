package topics.arrays;

/**
 * Created by PV029500 on 10/24/2016.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                recurse(i, j, board, word.toCharArray(), 0);
            }
        }
        return false;
    }

    public boolean recurse(int i, int j, char[][]board, char[] word, int curr) {
        if (curr == word.length - 1) return true;
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word[curr]) return false;
        board[i][j] = '0';

        boolean result = recurse(i + 1, j, board, word, curr + 1) ||
                            recurse(i - 1, j, board, word, curr + 1) ||
                            recurse(i, j + 1, board, word, curr + 1) ||
                            recurse(i, j - 1, board, word, curr + 1);
        board[i][j] = word[curr];
        return result;
    }
}
