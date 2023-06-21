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

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideViewNodes = new ArrayList<>();
        if (root == null) {
            return rightSideViewNodes;
        }
        
        dfs(root, 0, rightSideViewNodes);
        return rightSideViewNodes;
    }

    private void dfs(TreeNode root, int lvl, List<Integer> rightSideViewNodes) {
        if (root == null) {
            return;
        }

        if (lvl == rightSideViewNodes.size()) {
            rightSideViewNodes.add(root.val);
        }
        dfs(root.right, lvl + 1, rightSideViewNodes);
        dfs(root.left, lvl + 1, rightSideViewNodes);
    }
}