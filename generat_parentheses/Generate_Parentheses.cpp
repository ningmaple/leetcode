class Generate_Parentheses {
public:
    vector<string> generateParenthesis(int n) {
        if (n < 1) {
            return vector<string>();
        }
        
        vector<string> parenthesis;
        string sol = "";
        dfs(n, 0, 0, 0, sol, parenthesis);
        return parenthesis;
    }

private:
    void dfs(int n, int pairs, int left_counter, int right_counter, string& sol, vector<string>& parenthesis) {
        if (n == pairs) {
            parenthesis.push_back(sol);
            return;
        }
        
        if (left_counter < n) {
            sol.push_back('(');
            dfs(n, pairs, left_counter + 1, right_counter, sol, parenthesis);
            sol.erase(sol.size() - 1);
        }
        if (right_counter < left_counter) {
            sol.push_back(')');
            dfs(n, pairs + 1, left_counter, right_counter + 1, sol, parenthesis);
            sol.erase(sol.size() - 1);
        }
    }
};
