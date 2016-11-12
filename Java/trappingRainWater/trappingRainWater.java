public class Solution {
    public int trapRainWater(int[] heights) {
        if (heights == null || heights.length < 3) {
            return 0;
        }
        
        int start = 0, end = heights.length - 1;
        int startHeight = heights[start], endHeight = heights[end];
        int amount = 0;
        
        while (start < end) {
            if (startHeight < endHeight) {
                start++;
                if (startHeight > heights[start]) {
                    amount += startHeight - heights[start];
                } else {
                    startHeight = heights[start];
                }
            } else {
                end--;
                if (endHeight > heights[end]) {
                    amount += endHeight - heights[end];
                } else {
                    endHeight = heights[end];
                }
            }
            
        }
        
        return amount;
    }
}