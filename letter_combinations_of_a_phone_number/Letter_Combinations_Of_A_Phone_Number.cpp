class Letter_Combinations_Of_A_Phone_Number {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) {
            return vector<string>();
        }
        
        vector<vector<char>> map = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        string sol = "";
        vector<string> letter_combinations;
        dfs(digits, 0, sol, map, letter_combinations);        
        return letter_combinations;
    }
    
private:
    void dfs(string digits, int lvl, string& sol, vector<vector<char>>& map, vector<string>& letter_combinations) {
        if (lvl == digits.size()) {
            letter_combinations.push_back(sol);
            return;
        }

        vector<char> chars = map[digits[lvl] - '0' - 2];
        for (char ch : chars) {
            sol.push_back(ch);
            dfs(digits, lvl + 1, sol, map, letter_combinations);
            sol.erase(sol.size() - 1);
        }
    }
};
