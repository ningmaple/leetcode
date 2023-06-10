class Longest_Substring_Without_Repeating_Characters {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.empty()) {
            return 0;
        }
        
        unordered_set<char> table;
        int length_longest_substring = 0;
        int slow = 0;
        for (int fast = 0; fast < s.size(); fast++) {            
            while (table.find(s[fast]) != table.end()) {
                table.erase(s[slow++]);
            }
            
            table.insert(s[fast]);
            length_longest_substring = max(length_longest_substring, fast - slow + 1);
        }
        
        return length_longest_substring;
    }
};