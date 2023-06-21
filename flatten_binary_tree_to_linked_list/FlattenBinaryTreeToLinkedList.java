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

class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode[] prevRoot = new TreeNode[1];
        // dfsPrevOrder(root, prevRoot);
        dfsPostOrder(root, prevRoot);
    }
    
    private void dfsPrevOrder(TreeNode root, TreeNode[] prevRoot) {
        if (root == null) {
            return;
        }
        
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        if (prevRoot[0] != null) {
            prevRoot[0].right = root;
        }
        root.left = null;
        root.right = null;
        prevRoot[0] = root;
        
        dfsPrevOrder(leftNode, prevRoot);
        dfsPrevOrder(rightNode, prevRoot);
    }

    private void dfsPostOrder(TreeNode root, TreeNode[] prevRoot) {
        if (root == null) {
            return;
        }
       
        dfsPostOrder(root.right, prevRoot);
        dfsPostOrder(root.left, prevRoot);

        root.right = prevRoot[0];
        root.left = null;
        prevRoot[0] = root;
    }
}