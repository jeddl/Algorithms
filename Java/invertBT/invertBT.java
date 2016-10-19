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
    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}