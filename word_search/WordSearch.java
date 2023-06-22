class WordSearch {
    private static class Trie {
        private Map<Character, Trie> children;
        private boolean isWord;
        private String word;
        public Trie() {
            this.children = new HashMap<>();
            this.isWord = false;
            this.word = "";
        }
    }
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        
        Trie root = new Trie();
        Trie currRoot = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!currRoot.children.containsKey(ch)) {
                currRoot.children.put(ch, new Trie());
            }
            currRoot = currRoot.children.get(ch);
        }
        currRoot.isWord = true;
        currRoot.word = new String(word);
    
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                currRoot = root;
                if (dfs(board, i, j, dirs, visited, currRoot)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int x, int y, int[][] dirs, boolean[][] visited, Trie root) {
        if (!root.children.containsKey(board[x][y])) {
            return false;
        }
        
        visited[x][y] = true;
        root = root.children.get(board[x][y]);
        if (root.isWord) {
            return true;
        }
        
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[newX].length || visited[newX][newY]) {
                continue;
            }
            if (dfs(board, newX, newY, dirs, visited, root)) {
                return true;
            }
        }
        visited[x][y] = false;
        
        return false;
    }
}
