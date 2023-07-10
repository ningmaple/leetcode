class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        boolean[][] palindrome = checkPalindrome(s);
        int maxLen = 1;
        int startIdx = 0;
        for (int right = 1; right < s.length(); right++) {
            for (int left = 0; left < right; left++) {
                if (palindrome[left][right] && maxLen < right - left + 1) {
                    maxLen = right - left + 1;
                    startIdx = left;
                }
            }
        }
        
        return s.substring(startIdx, startIdx + maxLen);
    }
    
    private boolean[][] checkPalindrome(String s) {
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        for (int mid = 0; mid < s.length(); mid++) {
            int left = mid;
            int right = mid;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                palindrome[left--][right++] = true;
            }
            left = mid;
            right = mid + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                palindrome[left--][right++] = true;
            }
        }
        
        return palindrome;
    }
}