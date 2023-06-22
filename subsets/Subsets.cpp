class Subsets {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        if (nums.empty()) {
            return vector<vector<int>>();
        }
        
        vector<vector<int>> subsets;
        vector<int> sol;
        dfs(nums, 0, sol, subsets);
        return subsets;
    }
    
private:
    void dfs(vector<int>& nums, int lvl, vector<int>& sol, vector<vector<int>>& subsets) {
        if (lvl == nums.size()) {
            subsets.push_back(sol);
            return;
        }
        
        sol.push_back(nums[lvl]);
        dfs(nums, lvl + 1, sol, subsets);
        sol.pop_back();
        dfs(nums, lvl + 1, sol, subsets);
    }
};