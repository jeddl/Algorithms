public class Solution {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        // start either from top right or bottom left(make sure one start where one dimension is max)
        int start = m - 1, end = 0;
        int count = 0;
        
        while (start >= 0 && end < n) {
            if (matrix[start][end] < target) {
                end++;
            } else if (matrix[start][end] > target) {
                start--;
            } else {
                count++;
                start--;
                end++;
            }
        }
        return count;
    }
}