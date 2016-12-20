public class Solution {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A.length == 0 || A == null) {
            return 0;
        }
        
        int maxLength = 1;
        int length = 1;
        
        // From left to right
        for (int i = 1; i < A.length; ++i) {
            if (A[i - 1] < A[i]) {
                length++;
            } else {
                length = 1;
            }
            maxLength = Math.max(maxLength, length);
        }
        
        length = 1;
        // From right to left
        for (int i = A.length - 2; i >= 0; --i) {
            if (A[i + 1] < A[i]) {
                length++;
            } else {
                length = 1;
            }
            maxLength = Math.max(maxLength, length);
        }
        
        return maxLength;
    }
}