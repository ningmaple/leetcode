public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        
        Map<Character, int[]> charCounters = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!charCounters.containsKey(ch)) {
                charCounters.put(ch, new int[]{0});
            }
            charCounters.get(ch)[0]++;
        }
        
        int matches = 0;
        int slow = 0;
        int len = Integer.MAX_VALUE;
        int startIdx = -1;
        for (int fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            if (!charCounters.containsKey(ch)) {
                continue;
            }
            if (--charCounters.get(ch)[0] == 0) {
                matches++;
            }
            
            while (matches == charCounters.size() && slow <= fast) {
                if (fast - slow + 1 < len) {
                    len = fast - slow + 1;
                    startIdx = slow;
                }
                if (!charCounters.containsKey(s.charAt(slow))) {
                    slow++;
                    continue;
                }
                if (++charCounters.get(s.charAt(slow++))[0] == 1) {
                    matches--;
                }
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + len);
    }
}