class Longest_Increasing_Path_In_A_Matrix {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        if (matrix.empty() || matrix[0].empty()) {
            return 0;
        }
        
        vector<vector<int>> memo(matrix.size(), vector<int>(matrix[0].size(), 0));
        vector<vector<int>> dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int longest_path = 1;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                dfs(matrix, i, j, longest_path, memo, dirs);
            }
        }
        
        return longest_path;
    }

private:
    int dfs(vector<vector<int>>& matrix, int x, int y, int& longest_path, vector<vector<int>>& memo, vector<vector<int>>& dirs) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        
        int curr_path = 0;
        for (auto& dir : dirs) {
            int new_x = x + dir[0];
            int new_y = y + dir[1];
            if (new_x < 0 || new_x >= matrix.size() || new_y < 0 || new_y >= matrix[0].size() || matrix[new_x][new_y] <= matrix[x][y]) {
                continue;
            }
            curr_path = max(curr_path, dfs(matrix, new_x, new_y, longest_path, memo, dirs));
        }
        
        memo[x][y] = curr_path + 1;
        longest_path = max(longest_path, memo[x][y]);
        
        return memo[x][y];
    }
};