public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int result = 0;
        int[] dp = new int[nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = dp[i] < dp[j] + 1 ? dp[j] + 1 : dp[i];
                }
            }
            
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}
