class Trie {
private:
    unordered_map<char, Trie*> children;
    bool is_word;
    string word;
public:
    Trie() {
        this->is_word = false;
        this->word = "";
    }
    friend class Solution;
};

class Word_Search {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if (board.empty() || board[0].empty()) {
            return false;
        }
        if (word.empty()) {
            return true;
        }
        
        Trie* root = new Trie();
        Trie* curr = root;
        for (int i = 0; i < word.size(); i++) {
            if (curr->children.find(word[i]) == curr->children.end()) {
                curr->children[word[i]] = new Trie();
            }
            curr = curr->children[word[i]];
        }
        curr->is_word = true;
        curr->word = word;
        
        vector<vector<int>> dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        vector<vector<bool>> visited(board.size(), vector<bool>(board[0].size(), false));
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[i].size(); j++) {
                if (dfs(board, i, j, visited, dirs, root)) {
                    return true;
                }
            }
        }
        return false;
    }

private:
    bool dfs(vector<vector<char>>& board, int x, int y, vector<vector<bool>>& visited, vector<vector<int>>& dirs, Trie* root) {
        if (root->children.find(board[x][y]) == root->children.end()) {
            return false;
        }
        
        visited[x][y] = true;
        root = root->children[board[x][y]];
        if (root->is_word) {
            return true;
        }

        for (auto& dir : dirs) {
            int new_x = x + dir[0];
            int new_y = y + dir[1];
            if (new_x < 0 || new_x >= board.size() || new_y < 0 || new_y >= board[new_x].size() || visited[new_x][new_y]) {
                continue;
            }
            if (dfs(board, new_x, new_y, visited, dirs, root)) {
                return true;
            }
        }
        visited[x][y] = false;
        
        return false;
    }
};

