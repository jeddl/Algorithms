public class Solution {
    public boolean firstWillWin(int[] values) {
        int[] dp = new int[values.length + 1];
        if (values == null || values.length == 0) {
            return false;
        }
        int n = values.length;
        dp[0] = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += values[i];
        } 
        if (n >= 4) {
            dp[1] = values[n - 1];
            dp[2] = values[n - 2] + values[n - 1];
            dp[3] = values[n - 3] + values[n - 2];
            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(Math.min(dp[i - 2], dp[i - 3]) + values[n - i], Math.min(dp[i - 3], dp[i - 4]) + values[n - i] + values[n - i + 1]); 
            }
        } else if (n == 1) {
            dp[n] = values[n - 1];
        } else if (n == 2) {
            dp[n] = values[n - 1] + values[n - 2];
        } else if (n == 3) {
            dp[n] = values[n - 3] + values[n - 2];
        }
        return dp[n] * 2 > sum;
    }
}
