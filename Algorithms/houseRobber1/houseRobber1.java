public class Solution {
    public long houseRobber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        if (A.length < 2) {
            return A[0];
        }
        
        // maxAmount[i] is the max value that you can get from first i houses
        long[] maxAmount = new long[A.length + 1];
        // initialization
        maxAmount[1] = A[0];
        maxAmount[2] = Math.max(A[0], A[1]);
        
        for (int i = 2; i < A.length; i++) {
            maxAmount[i + 1] = Math.max(maxAmount[i], maxAmount[i - 1] + A[i]);
        }
        
        return maxAmount[A.length];
    }
}