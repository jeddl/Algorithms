class Solution {

    public int findPeak(int[] A) {

        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {  // peak
                return mid;
            }
            else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {  // up 
                start = mid;
            }
            else if (A[mid] > A[mid + 1] && A[mid] < A[mid - 1]) {  // down
                end = mid;
            }
            else if (A[mid] < A[mid + 1] && A[mid] < A[mid - 1]) {
                end = mid;
            }
        }
        return -1;
        
    }
    
}