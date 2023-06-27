class Score_Of_Parentheses {
public:
    int scoreOfParentheses(string s) {
        if (s.empty()) {
            return 0;
        }
        return scoreOfParentheses(s, 0, s.size() - 1);
    }

private:
    int scoreOfParentheses(string s, int start, int end) {
        int pairs = 1;
        int score = 0;
        int slow = start;
        for (int fast = start + 1; fast <= end; fast++) {
            if (s[fast] == '(') {
                pairs++;
                continue;
            }
            if (s[fast] == ')' && --pairs > 0) {
                continue;
            }

            if (slow + 1 == fast) {
                score += 1;
            } else {
                score += 2 * scoreOfParentheses(s, slow + 1, fast - 1);
            }

            pairs = 0;
            slow = fast + 1;
        }

        return score;
    }
};