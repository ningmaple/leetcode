class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() < 3) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left++) == s.charAt(right--));
        return left > right || validPalindrome(s, left, right + 1) || validPalindrome(s, left - 1, right);
    }
    
    private boolean validPalindrome(String s, int left, int right) {
        while (left <= right && s.charAt(left++) == s.charAt(right--));
        return left > right && s.charAt(left - 1) == s.charAt(right + 1);
    }
}