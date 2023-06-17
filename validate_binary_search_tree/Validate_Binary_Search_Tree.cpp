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

class Validate_Binary_Search_Tree {
public:
    bool isValidBST(TreeNode* root) {
        if (root == NULL) {
            return true;
        }
        
        return isValidBST(root, (long)INT_MIN - 1, (long)INT_MAX + 1);
    }
    
private:
    bool isValidBST(TreeNode* root, long min, long max) {
        if (root == NULL) {
            return true;
        }
        if (root->val >= max || root->val <= min) {
            return false;
        }
        return isValidBST(root->left, min, (long)root->val) && isValidBST(root->right, (long)root->val, max);
    }
};