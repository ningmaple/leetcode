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

class Binary_Tree_Right_Side_View {
public:
    vector<int> rightSideView(TreeNode* root) {
        if (root == NULL) {
            return vector<int>();
        }
        
        vector<int> right_side_view_nodes;
        dfs(root, 0, right_side_view_nodes);
        return right_side_view_nodes;
    }
    
private:
    void dfs(TreeNode* root, int lvl, vector<int>& right_side_view_nodes) {
        if (root == NULL) {
            return;
        }
        if (lvl == right_side_view_nodes.size()) {
            right_side_view_nodes.push_back(root->val);
        }
        
        dfs(root->right, lvl + 1, right_side_view_nodes);
        dfs(root->left, lvl + 1, right_side_view_nodes);
    }
};