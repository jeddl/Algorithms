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
        
        // Initializations
        for (int i = 0; i < layer; i++) {
            dpMin[layer - 1][i] = triangle.get(layer - 1).get(i);
        }

        // From bottom to top
        for (int i = layer - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dpMin[i][j] = Math.min(dpMin[i + 1][j], dpMin[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        
        return dpMin[0][0];
    }
}