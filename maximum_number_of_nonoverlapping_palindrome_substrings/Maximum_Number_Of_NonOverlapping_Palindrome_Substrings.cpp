class Maximum_Number_Of_NonOverlapping_Palindrome_Substrings {
public:
    int maxPalindromes(string s, int k) {
        if (s.empty() || k < 1) {
            return 0;
        }

        bool** palindromes = check_palindromes(s);
        int dp_table[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp_table[i] = 0;
        }

        for (int right = k; right <= s.length(); right++) {
            dp_table[right] = dp_table[right - 1];
            for (int left = 1; right - left + 1 >= k; left++) {
                if (palindromes[left - 1][right - 1]) {
                    dp_table[right] = max(dp_table[right], dp_table[left - 1] + 1);
                }
            }
        }

        return dp_table[s.length()];
    }

private:
    bool** check_palindromes(string& s) {
        bool** palindromes = new bool*[s.length()];
        for (int i = 0; i < s.size(); i++) {
            palindromes[i] = new bool[s.length()];
            for (int j = 0; j < s.size(); j++) {
                palindromes[i][j] = false;
            }
        }

        for (int mid = 0; mid < s.length(); mid++) {
            int left = mid;
            int right = mid;
            while (left >= 0 && right < s.length() && s[left] == s[right]) {
                palindromes[left--][right++] = true;
            }

            left = mid;
            right = mid + 1;
            while (left >= 0 && right < s.length() && s[left] == s[right]) {
                palindromes[left--][right++] = true;
            }
        }

        return palindromes;
    }
};