class Valid_Sudoku {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        if (board.empty() || board.size() != 9) {
            return false;
        }
        
        for (int row = 0; row < board.size(); row++) {
            if (board[row].size() != 9 || !isValid(board, row, row, 0, board[row].size() - 1)) {
                return false;
            }
        }
        for (int col = 0; col < board[0].size(); col++) {
            if (!isValid(board, 0, board.size() - 1, col, col)) {
                return false;
            }
        }
        for (int row = 0; row < board.size(); row += 3) {
            for (int col = 0; col < board[0].size(); col += 3) {
                if (!isValid(board, row, row + 2, col, col + 2)) {
                    return false;
                }
            }
        }
        
        return true;
    }

private:
    bool isValid(vector<vector<char>>& board, int row_lower_bound, int row_upper_bound, int col_lower_bound, int col_upper_bound) {
        unordered_set<char> nums;
        for (int row = row_lower_bound; row <= row_upper_bound; row++) {
            for (int col = col_lower_bound; col <= col_upper_bound; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (nums.find(board[row][col]) == nums.end()) {
                    nums.insert(board[row][col]);
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
};