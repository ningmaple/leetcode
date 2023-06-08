class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        return longestSubstring(s, 0, s.length() - 1, k);
    }

    private int longestSubstring(String s, int left, int right, int k) {
        if (right - left + 1 < k) {
            return 0;
        }

        Map<Character, int[]> table = new HashMap<>();
        for (int i = left; i <= right; i++) {
            char ch = s.charAt(i);
            if (!table.containsKey(ch)) {
                table.put(ch, new int[]{0});
            }
            table.get(ch)[0]++;
        }

        if (isValid(table, k)) {
            return right - left + 1;
        }

        int slow = left;
        int fast = left;
        int maxLen = 0;
        for (; fast <= right; fast++) {
            if (table.get(s.charAt(fast))[0] >= k) {
                continue;
            }
            maxLen = Math.max(maxLen, longestSubstring(s, slow, fast - 1, k));
            slow = fast + 1;
        }
        maxLen = Math.max(maxLen, longestSubstring(s, slow, fast - 1, k));
        
        return maxLen;
    }

    private boolean isValid(Map<Character, int[]> table, int k) {
        for (Map.Entry<Character, int[]> entry : table.entrySet()) {
            if (entry.getValue()[0] < k) {
                return false;
            }
        }
        return true;
    }
}