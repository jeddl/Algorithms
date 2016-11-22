public class Solution {
    public int triangleCount(int S[]) {
        if (S.length < 3 || S == null) {
            return 0;
        }
        
        Arrays.sort(S);
        int len = S.length;
        int count = 0;
        
        for (int edgeLength = len - 1; edgeLength >= 2; edgeLength--) {
            int start = 0, end = edgeLength - 1;
            while (start < end) {
                if (S[start] + S[end] > S[edgeLength]) {
                    count += end - start;
                    end--;
                } else {
                    start++;
                }
            }
        }
        
        return count;
    }
}
