class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        
        // For rows
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited, board[i][j])) {
                    return false;
                }
            }
        }
        
        // For columns
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited, board[j][i])) {
                    return false;
                }
            }
        }
        
        // 9 small matrix
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!isValid(visited, board[i + k / 3][j + k % 3])) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(boolean[] visited, char c) {
        if (c == '.') {
            return true;
        }
        
        int num = c - '0';
        
        // visited[num - 1]: array starts from 0, visited[0] = true means '1' has been visited
        if (num < 1 || num > 9 || visited[num - 1]) {
            return false;
        }
        
        visited[num - 1] = true;
        return true;
    }
};