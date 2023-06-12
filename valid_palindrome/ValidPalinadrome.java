class ValidPalinadrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char lch = s.charAt(left);
            char rch = s.charAt(right);
            if (!Character.isLetterOrDigit(lch)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rch)) {
                right--;
                continue;
            }
            
            if (lch != rch && (Character.isDigit(lch) || Character.isDigit(rch))) {
                return false;
            }
            if (lch - 'A' > 26) {
                lch -= 32;
            }
            if (rch - 'A' > 26) {
                rch -= 32;
            }
            if (lch != rch) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}