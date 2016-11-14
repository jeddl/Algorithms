public class Solution {
    public int maxSubArray(int[] nums) {
        int curMaxSum = nums[0];
        int prevMaxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (prevMaxSum < 0) {
                prevMaxSum = nums[i];
            } else {
                prevMaxSum += nums[i];
            }
            
            curMaxSum = Math.max(curMaxSum, prevMaxSum);
        }
        
        return curMaxSum;
    }
}