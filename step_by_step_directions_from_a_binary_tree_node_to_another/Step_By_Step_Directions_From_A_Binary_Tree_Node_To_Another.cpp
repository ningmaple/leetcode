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
class Step_By_Step_Directions_From_A_Binary_Tree_Node_To_Another {
public:
    string getDirections(TreeNode* root, int startValue, int destValue) {
        if (root == NULL) {
            return "";
        }

        TreeNode* lca = find_lca(root, startValue, destValue);
        if (lca == NULL) {
            return "";
        }
        if (lca->val == startValue) {
            string path = "";
            get_directions_to_child(lca, destValue, path);
            return path;
        }
        if (lca->val == destValue) {
            string path = "";
            get_directions_to_parent(lca, startValue, path);
            return path;
        }

        string path1 = "";
        get_directions_to_parent(lca, startValue, path1);
        string path2 = "";
        get_directions_to_child(lca, destValue, path2);
        return path1 + path2;
    }

private:
    bool get_directions_to_parent(TreeNode* root, int destValue, string& path) {
        if (root == NULL) {
            return false;
        }
        if (root->val == destValue) {
            return true;
        }
        
        path.push_back('U');
        if (get_directions_to_parent(root->left, destValue, path)) {
            return true;
        }
        if (get_directions_to_parent(root->right, destValue, path)) {
            return true;
        }
        path.erase(path.size() - 1);

        return false;
    }

    bool get_directions_to_child(TreeNode* root, int destValue, string& path) {
        if (root == NULL) {
            return false;
        }
        if (root->val == destValue) {
            return true;
        }
        
        path.push_back('L');
        if (get_directions_to_child(root->left, destValue, path)) {
            return true;
        }
        path.erase(path.size() - 1);
        path.push_back('R');
        if (get_directions_to_child(root->right, destValue, path)) {
            return true;
        }
        path.erase(path.size() - 1);
        return false;
    }

    TreeNode* find_lca(TreeNode* root, int startValue, int destValue) {
        if (root == NULL || root->val == startValue || root->val == destValue) {
            return root;
        }

        TreeNode* left = find_lca(root->left, startValue, destValue);
        TreeNode* right = find_lca(root->right, startValue, destValue);
        if (left != NULL && right != NULL) {
            return root;
        }
        return left == NULL ? right : left;
    }
};