public class Solution {
    public int minimumSize(int[] nums, int s) {
        if (s <= 0 || nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        
        for (start = 0; start < nums.length; ++start) {
            while (end < nums.length && sum < s) {
                sum += nums[end];
                end++;
            }
            
            if (sum >= s) {
                minLength = Math.min(minLength, end - start);
            }
            
            sum -= nums[start];
        }
        
        if (minLength == Integer.MAX_VALUE) {
            return -1;
        }
        
        return minLength;
    }
}