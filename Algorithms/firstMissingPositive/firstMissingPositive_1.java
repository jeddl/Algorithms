public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        
        Arrays.sort(A);
        
        int index = 0;
        
        while (index < A.length) {
            // Find the start of positive number
            if (A[index] > 0) {
                break;
            }
            // If all numbers are negative
            if (index == A.length - 1) {
                return 1;
            }
            index++;
        }
        if (A[index] != 1) {
            return 1;
        } else {
            for (int i = index + 1; i < A.length; i++) {
                if (A[i] - A[i - 1] > 1) {
                    return A[i - 1] + 1;
                }
            }
        }
        
        return A[A.length - 1] + 1;
    }
}