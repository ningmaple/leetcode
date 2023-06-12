class Group_Anagrams {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        if (strs.empty()) {
            return vector<vector<string>>();
        }
        
        unordered_map<string, vector<string>> table;
        for (int i = 0; i < strs.size(); i++) {
            string pattern(strs[i]);
            sort(pattern.begin(), pattern.end());
            table[pattern].push_back(strs[i]);
        }
        
        vector<vector<string>> group_anagrams;
        for (auto entry : table) {
            group_anagrams.push_back(entry.second);
        }
        return group_anagrams;
    }
};