class Solution {
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || A.length == 0) {
            return B;
        }
        if (B == null || B.length == 0) {
            return A;
        }
        
        int[] result = new int[A.length + B.length];
        int a = 0, b = 0, k = 0;
        
        while (a < A.length && b < B.length) {
            if (A[a] < B[b]) {
                result[k] = A[a];
                a++;
                k++;
            } else {
                result[k] = B[b];
                b++;
                k++;
            }
        }
        
        while (a < A.length) {
            result[k] = A[a];
            a++;
            k++;
        }
        
        while (b < B.length) {
            result[k] = B[b];
            b++;
            k++;
        }
        
        return result;
        
    }
}