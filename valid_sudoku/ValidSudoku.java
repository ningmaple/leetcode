class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || board.length != board[0].length) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, i, 0, board[0].length - 1)) {
                continue;
            }
            return false;
        }
        
        for (int i = 0; i < board[0].length; i++) {
            if (isValid(board, 0, board.length - 1, i, i)) {
                continue;
            }
            return false;
        }
        
        for (int i = 0; i < board.length - 2; i += 3) {
            for (int j = 0; j < board[0].length - 2; j += 3) {
                if (isValid(board, i, i + 2, j, j + 2)) {
                    continue;
                }
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int xLeft, int xRight, int yLeft, int yRight) {
        Set<Character> table = new HashSet<>();
        for (int i = xLeft; i <= xRight; i++) {
            for (int j = yLeft; j <= yRight; j++) {
                if (board[i][j] != '.' && table.contains(board[i][j])) {
                    return false;
                }
                table.add(board[i][j]);
            }
        }
        
        return true;
    }
}