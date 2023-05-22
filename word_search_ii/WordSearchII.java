class WordSearchII {
    private static class TrieNode {
        private final Map<Character, TrieNode> children;
        private boolean isWord;
        private String word;
        public TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
            this.word = "";
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null || words.length == 0) {
            return new ArrayList<String>();
        }
        
        TrieNode root = new TrieNode();
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            TrieNode currRoot = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!currRoot.children.containsKey(ch)) {
                    currRoot.children.put(ch, new TrieNode());
                }
                currRoot = currRoot.children.get(ch);
            }
            currRoot.isWord = true;
            currRoot.word = word;
            wordsSet.add(word);
        }
        
        List<String> foundWords = new ArrayList<>();
        Map<Character, TrieNode> starts = root.children;
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (starts.containsKey(board[i][j])) {
                    dfs(board, dirs, new boolean[board.length][board[i].length], i, j, root.children.get(board[i][j]), foundWords, wordsSet);
                }
            }
        }
        
        return foundWords;
    }
    
    private void dfs(char[][] board, int[][] dirs, boolean[][] visited, int x, int y, TrieNode root, List<String> words, Set<String> dict) {
        visited[x][y] = true;
        if (root.isWord && dict.contains(root.word)) {
            words.add(root.word);
            dict.remove(root.word);
        }

        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[newX].length || visited[newX][newY] || !root.children.containsKey(board[newX][newY])) {
                continue;
            }
            dfs(board, dirs, visited, newX, newY, root.children.get(board[newX][newY]), words, dict);
        }
        visited[x][y] = false;
    }
}