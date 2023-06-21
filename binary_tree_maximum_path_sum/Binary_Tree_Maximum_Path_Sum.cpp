/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Binary_Tree_Maximum_Path_Sum {
public:
    int maxPathSum(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        
        int max_sum = INT_MIN;
        dfs(root, max_sum);
        return max_sum;
    }
    
private:
    int dfs(TreeNode* root, int& max_sum) {
        if (root == NULL) {
            return 0;
        }
        
        int left = max(0, dfs(root->left, max_sum));
        int right = max(0, dfs(root->right, max_sum));
        max_sum = max(max_sum, root->val + left + right);
        return root->val + max(left, right);
    }
};
