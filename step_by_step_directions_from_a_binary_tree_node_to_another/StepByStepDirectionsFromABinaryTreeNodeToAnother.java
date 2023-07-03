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
class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null || startValue == destValue) {
            return "";
        }

        TreeNode lca = findLCA(root, startValue, destValue);
        if (lca == null) {
            return "";
        }

        String[] path = new String[]{null};
        if (lca.val == startValue) {
            getDirectionsToChild(lca, destValue, new StringBuilder(), path);
            return path[0];
        }
        if (lca.val == destValue) {
            getDirectionsToParent(lca, startValue, new StringBuilder(), path);
            return new StringBuilder(path[0]).reverse().toString();
        }

        String[] path2 = new String[]{null};
        getDirectionsToParent(lca, startValue, new StringBuilder(), path);
        getDirectionsToChild(lca, destValue, new StringBuilder(), path2);
        return path[0] + path2[0];
    }

    private void getDirectionsToChild(TreeNode root, int destValue, StringBuilder sb, String[] path) {
        if (root == null|| path[0] != null) {
            return;
        }
        if (root.val == destValue ) {
            path[0] = sb.toString();
            return;
        }
        
        sb.append("L");
        getDirectionsToChild(root.left, destValue, sb, path);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("R");
        getDirectionsToChild(root.right, destValue, sb, path);
        sb.deleteCharAt(sb.length() - 1);
    }

    private void getDirectionsToParent(TreeNode root, int destValue, StringBuilder sb, String[] path) {
        if (root == null|| path[0] != null) {
            return;
        }
        if (root.val == destValue ) {
            path[0] = sb.toString();
            return;
        }
        
        sb.append("U");
        getDirectionsToParent(root.left, destValue, sb, path);
        getDirectionsToParent(root.right, destValue, sb, path);
        sb.deleteCharAt(sb.length() - 1);
    }

    private TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null || root.val == startValue || root.val == destValue) {
            return root;
        }

        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}