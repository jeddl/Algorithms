/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int houseRobber3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] answer = dfs(root);
        
        return Math.max(answer[0], answer[1]);
    }
    
    private int[] dfs(TreeNode root) {
        // maxVal[0] is the max value without current root value
        // maxVal[1] is the max value with current root value
        int[] maxVal = new int[2];
        if (root == null) {
            return maxVal;
        }
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        maxVal[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        maxVal[1] = left[0] + right[0] + root.val;
        
        return maxVal;
    }
}