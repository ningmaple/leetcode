class Minimum_Window_Substring {
public:
    string minWindow(string s, string t) {
        if (s.empty() || t.empty()) {
            return "";
        }
        
        unordered_map<char, int> table;
        for (int i = 0; i < t.size(); i++) {
            table[t[i]]++;
        }
        
        int start_idx = 0;
        int min_len = INT_MAX;
        int slow = 0;
        int matches = 0;
        for (int fast = 0; fast < s.size(); fast++) {
            if (table.find(s[fast]) == table.end() || (--table[s[fast]] == 0 && ++matches < table.size())) {
                continue;
            }
            
            while (matches == table.size()) {
                if (min_len > fast - slow + 1) {
                    min_len = fast - slow + 1;
                    start_idx = slow;
                }
                if (table.find(s[slow]) == table.end()) {
                    slow++;
                    continue;
                }
                if (++table[s[slow++]] > 0) {
                    matches--;
                }
            }
        }
        
        return min_len == INT_MAX ? "" : s.substr(start_idx, min_len);
    }
};