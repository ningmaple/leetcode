class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return scoreOfParentheses(s, 0, s.length() - 1);
    }

    private int scoreOfParentheses(String s, int start, int end) {
        int pairs = 1;
        int score = 0;
        int slow = start;
        for (int fast = start + 1; fast <= end; fast++) {
            char ch = s.charAt(fast);
            if (ch == '(') {
                pairs++;
                continue;
            }
            if (ch == ')' && --pairs > 0) {
                continue;
            }

            if (slow + 1 == fast) {
                score += 1;
            } else {
                score += 2 * scoreOfParentheses(s, slow + 1, fast - 1);
            }
            
            slow = fast + 1;
            pairs = 0;
        }

        return score;
    }
}