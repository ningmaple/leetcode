public class WordSquares {
    private static class Trie {
        private Map<Character, Trie> children;
        private boolean isWord;
        private String word;
        public Trie() {
            this.children = new HashMap<>();
            this.word = "";
            this.isWord = false;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<List<String>>();
        }

        Trie root = new Trie();
        for (String word : words) {
            Trie currRoot = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!currRoot.children.containsKey(ch)) {
                    currRoot.children.put(ch, new Trie());
                }
                currRoot = currRoot.children.get(ch);
            }
            currRoot.isWord = true;
            currRoot.word = word;
        }

        List<List<String>> ans = new ArrayList<>();
        for (String word : words) {
            char[][] sol = new char[words[0].length()][words[0].length()];
            for (int i = 0; i < word.length(); i++) {
                sol[0][i] = word.charAt(i);
                dfs(1, root, root, sol, ans);
            }
        }

        return ans;
    }

    private void dfs(int lvl, Trie root, Trie dummy, char[][] sol, List<List<String>> ans) {
        if (lvl == sol.length) {
            List<String> currAns = new ArrayList<>();
            for (int i = 0; i < sol.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < sol[i].length; j++) {
                    sb.append(sol[i][j]);
                }
                currAns.add(sb.toString());
            }
            ans.add(currAns);
            return;
        }

        Trie[] currRoot = new Trie[]{root};
        if (isValid(lvl, currRoot, sol)) {
            int idx = 0;
            for (; idx < lvl; idx++) {
                sol[lvl][idx] = sol[idx][lvl];
            }
            append(lvl, idx, root, currRoot[0], sol, ans);
        }
    }

    private void append(int row, int col, Trie root, Trie currRoot, char[][] sol, List<List<String>> ans) {
        if (col == sol.length) {
            dfs(row + 1, root, root, sol, ans);
            return;
        }

        Map<Character, Trie> children = currRoot.children;
        for (Map.Entry<Character, Trie> child : children.entrySet()) {
            sol[row][col] = child.getKey();
            append(row, col + 1, root, child.getValue(), sol, ans);
        }
    }

    private boolean isValid(int lvl, Trie[] root, char[][] sol) {
        int counter = 0;
        for (int i = 0; i < lvl; i++) {
            char ch = sol[i][lvl];
            if (!root[0].children.containsKey(ch)) {
                continue;
            }
            root[0] = root[0].children.get(ch);
            counter++;
        }

        return counter == lvl;
    }
}