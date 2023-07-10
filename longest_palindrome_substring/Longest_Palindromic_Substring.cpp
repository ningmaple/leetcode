class Longest_Palindromic_Substring {
public:
    string longestPalindrome(string s) {
        if (s.empty()) {
            return "";
        }
        
        bool** palindrome = check_palindrome(s);
        int start_idx = 0;
        int max_len = 1;
        for (int right = 1; right < s.size(); right++) {
            for (int left = 0; left < right; left++) {
                if (palindrome[left][right] && max_len < right - left + 1) {
                    start_idx = left;
                    max_len = right - left + 1;
                }
            }
        }
        
        return s.substr(start_idx, max_len);
    }
    
private:
    bool** check_palindrome(string& s) {
        bool** palindrome = new bool*[s.size()];
        for (int i = 0; i < s.size(); i++) {
            palindrome[i] = new bool[s.size()];
            for (int j = 0; j < s.size(); j++) {
                palindrome[i][j] = false;
            }
        }
        
        for (int mid = 0; mid < s.size(); mid++) {
            int left = mid;
            int right = mid;
            while (left >= 0 && right < s.size() && s[left] == s[right]) {
                palindrome[left--][right++] = true;
            }
            
            left = mid;
            right = mid + 1;
            while (left >= 0 && right < s.size() && s[left] == s[right]) {
                palindrome[left--][right++] = true;
            }
        }
        
        return palindrome;
    }
};