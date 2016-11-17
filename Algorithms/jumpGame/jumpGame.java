public class Solution {
    public boolean canJump(int[] A) {
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && A[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[A.length - 1];
    }
}
