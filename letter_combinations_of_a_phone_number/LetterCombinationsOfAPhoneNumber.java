class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> letterCombinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return letterCombinations;
        }
        
        String[] table = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, table, 0, new StringBuilder(), letterCombinations);
        return letterCombinations;
    }
    
    private void dfs(String digits, String[] table, int lvl, StringBuilder sb, List<String> letterCombinations) {
        if (lvl == digits.length()) {
            letterCombinations.add(sb.toString());
            return;
        }

        int idx = digits.charAt(lvl) - '2';
        String letters = table[idx];
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            sb.append(ch);
            dfs(digits, table, lvl + 1, sb, letterCombinations);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
