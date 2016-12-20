public class Solution {
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        // sum[i]: sum of the values when i coins left
        int[] sum = new int[n + 1];
        // dp[i]: the max that current player can get when i coins left
        int[] dp = new int[n + 1];
        dp[1] = values[n - 1];
        
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + values[n - i];
        }
        
        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.max(sum[i] - dp[i - 1], sum[i] - dp[i - 2]);
        }
        
        return dp[n] > sum[n] / 2;
    }
}