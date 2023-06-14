class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k < 1) {
            return 0;
        }
        
        Map<Character, int[]> table = new HashMap<>();
        int slow = 0;
        int maxLen = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            if (!table.containsKey(ch)) {
                table.put(ch, new int[]{0});
            }
            table.get(ch)[0]++;
            if (table.size() <= k) {
                maxLen = Math.max(maxLen, fast - slow + 1);
                continue;
            }
            
            while (table.size() > k && --table.get(s.charAt(slow++))[0] > 0);
            table.remove(s.charAt(slow - 1));
        }
        
        return maxLen;
    }
}