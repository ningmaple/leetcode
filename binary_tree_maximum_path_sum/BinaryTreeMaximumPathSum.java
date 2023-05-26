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

class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }
    
    private int dfs(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(0, dfs(root.left, maxSum));
        int right = Math.max(0, dfs(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}