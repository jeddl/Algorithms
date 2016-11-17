public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle == null) {
            return -1;
        }
        if (triangle.get(0).size() == 0 || triangle.get(0) == null) {
            return -1;
        }
        
        int layer = triangle.size();
        // dpMin[i][j]: minimum path value from 0,0 to i, j
        int[][] dpMin = new int[layer][layer];
        dpMin[0][0] = triangle.get(0).get(0);
        
        // Initialization
        for (int i = 1; i < layer; i++) {
            dpMin[i][0] = dpMin[i - 1][0] + triangle.get(i).get(0);
            dpMin[i][i] = dpMin[i - 1][i - 1] + triangle.get(i).get(i);
        }
        
        // From top to buttom
        for (int i = 2; i < layer; i++) {
            for (int j = 1; j < i; j++) {
                dpMin[i][j] = Math.min(dpMin[i - 1][j - 1], dpMin[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < layer; i++) {
            min = Math.min(min, dpMin[layer - 1][i]);
        }
        
        return min;
    }
}