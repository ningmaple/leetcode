public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        char[] charArray = s.toCharArray();
        Set<Character> chars = new HashSet<>();
        chars.add('(');
        chars.add('[');
        chars.add('{');
        
        int slow = -1;
        for (int fast = 0; fast < charArray.length; fast++) {
            char ch = charArray[fast];
            if (chars.contains(ch)) {
                charArray[++slow] = ch;
                continue;
            }
            if (ch == ')' && (slow < 0 || charArray[slow--] != '(')) {
                return false;
            }
            if (ch == ']' && (slow < 0 || charArray[slow--] != '[')) {
                return false;
            }
            if (ch == '}' && (slow < 0 || charArray[slow--] != '{')) {
                return false;
            }
        }

        return slow == -1;
    }
}