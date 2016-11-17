public class Solution {
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
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
            return true;
        }
        
        if (T1 == null) {
            return false;
        }
        
        // If identical
        if (identical(T1, T2)) {
            return true;
        }
        
        // Go to subtree of T1 and see if they are identical
        if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2)) {
            return true;
        }
        
        return false;
    }
    
    private boolean identical(TreeNode T1, TreeNode T2) {
        if (T1 == null || T2 == null) {
            return T1 == T2;
        }
        
        if (T1.val != T2.val) {
            return false;
        }
        
        return identical(T1.left, T2.left) && identical(T1.right, T2.right);
    }
}