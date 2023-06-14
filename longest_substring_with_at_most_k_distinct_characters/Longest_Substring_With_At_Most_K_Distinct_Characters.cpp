class Longest_Substring_With_At_Most_K_Distinct_Characters {
public:
    int lengthOfLongestSubstringKDistinct(string s, int k) {
        if (s.empty() || k < 1) {
            return 0;
        }

        unordered_map<char, int> table;
        int slow = 0;
        int max_len = 0;
        for (int fast = 0; fast < s.size(); fast++) {
            table[s[fast]]++;
            if (table.size() <= k) {
                max_len = max(max_len, fast - slow + 1);
                continue;
            }

            while (table.size() > k && --table[s[slow++]] > 0);
            table.erase(s[slow - 1]);
        }

        return max_len;
    }
};