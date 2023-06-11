class StringToInteger {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        long num = 0;
        int sign = 1;
        boolean isStart = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ' && !isStart) {
                continue;
            }

            if (ch == '-' && !isStart) {
                isStart = true;
                sign = -1;
                continue;
            }
            if (ch == '+' && !isStart) {
                isStart = true;
                continue;
            }

            isStart = true;
            if (!Character.isDigit(ch)) {
                break;
            }
            
            num *= 10;
            num += ch - '0';
            
            if (sign * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        
        return sign * (int)num;
    }
}