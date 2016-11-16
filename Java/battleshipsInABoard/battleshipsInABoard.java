public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i > 0 && board[i - 1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X')) {
                    continue;
                }
                if (board[i][j] != 'X') {
                    continue;
                }
                
                count++;
            }
        }
        
        return count;
    }
}