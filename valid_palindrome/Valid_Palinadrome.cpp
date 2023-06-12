class Valid_Palinadrome {
public:
    bool isPalindrome(string s) {
        if (s.empty() || s.size() < 2) {
            return true;
        }
        
        int left = 0;
        int right = s.size() - 1;
        while (left <= right) {
            if (isalpha(s[left]) == 0 && isdigit(s[left]) == 0) {
                left++;
                continue;
            }
            if (isalpha(s[right]) == 0 && isdigit(s[right]) == 0) {
                right--;
                continue;
            }
            if (s[left] != s[right] && (isdigit(s[left]) == 1 || isdigit(s[right]) == 1)) {
                return false;
            }
            
            if (s[left] - 'A' > 26) {
                s[left] -= 32;
            }
            if (s[right] - 'A' > 26) {
                s[right] -= 32;
            }
            if (s[left] != s[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
};