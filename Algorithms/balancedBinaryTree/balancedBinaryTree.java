/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}