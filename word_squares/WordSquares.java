public class WordSquares {
    private static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isWord;
        private String word;
        public TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
            this.word = "";
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<List<String>>();
        }
        
        TrieNode root = new TrieNode();
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
        }
        
        List<List<String>> wordSquaresList = new ArrayList<>();
        for (String word : words) {
            char[][] sol = new char[word.length()][word.length()];
            for (int i = 0; i < word.length(); i++) {
                sol[0][i] = word.charAt(i);
            }
            dfs(root, 1, sol, wordSquaresList);
        }
        
        return wordSquaresList;
    }
    
    private void dfs(TrieNode root, int lvl, char[][] sol, List<List<String>> wordSquaresList) {
        if (lvl == sol.length) {
            List<String> words = new ArrayList<>();
            for (int i = 0; i < sol.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < sol[i].length; j++) {
                    sb.append(sol[i][j]);
                }
                words.add(sb.toString());
            }
            wordSquaresList.add(words);
            return;
        }
        
        TrieNode[] currRoot = new TrieNode[]{root};
        if (isValid(sol, currRoot, lvl)) {
            append(sol, root, currRoot[0], lvl, lvl, wordSquaresList);
        }
    }
    
    private void append(char[][] sol, TrieNode root, TrieNode currRoot, int row, int col, List<List<String>> wordSquaresList) {
        if (col == sol[0].length) {
            dfs(root, row + 1, sol, wordSquaresList);
            return;
        }
        
        Map<Character, TrieNode> children = currRoot.children;
        for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
            sol[row][col] = child.getKey();
            append(sol, root, child.getValue(), row, col + 1, wordSquaresList);
        }
    }
    
    private boolean isValid(char[][] sol, TrieNode[] root, int lvl) {
        for (int i = 0; i < lvl; i++) {
            if (!root[0].children.containsKey(sol[i][lvl])) {
                return false;
            }
            sol[lvl][i] = sol[i][lvl];
            root[0] = root[0].children.get(sol[i][lvl]);
        }
        
        return true;
    }
}