public class LongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, int[]> table = new HashMap<>();
        int slow = 0;
        int maxLengthOfSubstring = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            if (!table.containsKey(ch)) {
                table.put(ch, new int[]{0});
            }
            table.get(ch)[0]++;
            
            if (table.size() > 2 && --table.get(s.charAt(slow++))[0] == 0) {
                table.remove(s.charAt(slow - 1));
            }
            
            maxLengthOfSubstring = Math.max(maxLengthOfSubstring, fast - slow + 1);
        }
        
        return maxLengthOfSubstring;
    }
}