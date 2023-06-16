class Valid_Palindrome_II {
public:
    bool validPalindrome(string s) {
        if (s.empty()) {
            return true;
        }
        
        int left = 0;
        int right = s.size() - 1;
        while (left <= right) {
            if (s[left++] == s[right--]) {
                continue;
            }
            return validPalindrome(s, left, right + 1) || validPalindrome(s, left - 1, right);
        }
        
        return true;
    }
private:
    bool validPalindrome(string s, int left, int right) {
        while (left <= right && s[left] == s[right]) {
            left++;
            right--;
        }
        return left > right;
    }
};