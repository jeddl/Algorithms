public class Solution {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(matrix[i][j])) {
                    map.put(matrix[i][j], 1);
                } else {
                    map.put(matrix[i][j], map.get(matrix[i][j]) + 1);
                }
                
            }
        }

        if (map.containsKey(target)) {
            return map.get(target);
        }

        return 0;
    }
}