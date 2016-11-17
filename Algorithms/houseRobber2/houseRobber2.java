public class Solution {
    public int houseRobber2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        if (A.length < 2) {
            return A[0];
        }
        
        // maxAmount[i] for maxAmount value that you can get from first i houses
        int[] maxAmount = new int[A.length + 1];
        // initialization
        maxAmount[1] = A[0];
        maxAmount[2] = Math.max(A[0], A[1]);
        
        for (int i = 2; i < A.length; i++) {
            maxAmount[i + 1] = Math.max(maxAmount[i], maxAmount[i - 1] + A[i]);
        }
        
        // Check if the the first house should be given up
        if (A[0] + A[2] > A[1]) {
            maxAmount[A.length] = Math.max(maxAmount[A.length - 1], maxAmount[A.length - 2] + A[A.length - 1] - A[0]);
        }
        
        return maxAmount[A.length];
    }
}