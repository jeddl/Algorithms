public class Solution {
    public int numTrees(int n) {
        int[] ans = new int[n + 2];
        ans[0] = 1;
        ans[1] = 1;
        
        for(int i = 2;  i <= n; i++){
            for(int j = 0; j < i; j++){
                ans[i] += ans[j] * ans[i - j - 1];
            }
        }
        
        return ans[n];
    }
}