public class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        if (heights == null || heights.length <= 1) {
            return max;
        }
        
        int start = 0, end = heights.length - 1;
        
        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(heights[end], heights[start]));
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }
        
        return max;
    }
}