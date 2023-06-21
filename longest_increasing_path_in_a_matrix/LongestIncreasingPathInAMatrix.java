class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int[][] memo = new int[matrix.length][matrix[0].length];
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (memo[i][j] == 0) {
                    dfs(matrix, dirs, i, j, memo);
                    ans = Math.max(ans, memo[i][j]);
                }
            }
        }
        return ans;
    }
    
    private int dfs(int[][] matrix, int[][] dirs, int x, int y, int[][] memo) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        
        int ans = 0;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length || matrix[x][y] >= matrix[newX][newY]) {
                continue;
            }
            ans = Math.max(ans, dfs(matrix, dirs, newX, newY, memo));
        }
        memo[x][y] = ++ans;
        return ans;
    }
}