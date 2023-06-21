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

class Flatten_Binary_Tree_To_Linked_List {
public:
    void flatten(TreeNode* root) {
        if (root == NULL) {
            return;
        }

        TreeNode* prev_root = NULL;
        // dfs_preorder(root, &prev_root);
        dfs_postorder(root, &prev_root);
    }

private:
    void dfs_preorder(TreeNode* root, TreeNode** prev_root) {
        if (root == NULL) {
            return;
        }

        TreeNode* left_node = root->left;
        TreeNode* right_node = root->right;
        if ((*prev_root) != NULL) {
            (*prev_root)->right = root;
        }
        root->left = NULL;
        root->right = NULL;
        *prev_root = root;

        dfs_preorder(left_node, prev_root);
        dfs_preorder(right_node, prev_root);
    }

    void dfs_postorder(TreeNode* root, TreeNode** prev_root) {
        if (root == NULL) {
            return;
        }

        dfs_postorder(root->right, prev_root);
        dfs_postorder(root->left, prev_root);

        root->right = *prev_root;
        root->left = NULL;
        *prev_root = root;
    }
};
