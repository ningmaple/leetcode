/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] ans = new int[1];
        diameterOfBinaryTree(root, ans);
        return ans[0];
    }
    
    private int diameterOfBinaryTree(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }
        
        int left = diameterOfBinaryTree(root.left, ans);
        int right = diameterOfBinaryTree(root.right, ans);
        ans[0] = Math.max(ans[0], left + right);
        
        return Math.max(left, right) + 1;
    }
}
