public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = findWord(board, word, i, j, 0);
                    
                    if (result) {
                        return result;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean findWord(char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(pos)) {
            return false;
        }
        
        board[i][j] = '#';
        boolean tempResult = (findWord(board, word, i - 1, j, pos + 1)
                              || findWord(board, word, i, j - 1, pos + 1)
                              || findWord(board, word, i + 1, j, pos + 1)
                              || findWord(board, word, i, j + 1, pos + 1));
        board[i][j] = word.charAt(pos);
        
        return tempResult;
    }
}