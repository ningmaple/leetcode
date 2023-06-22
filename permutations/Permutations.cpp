class Permutations {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        if (nums.empty()) {
            return vector<vector<int>>();
        }
        
        vector<vector<int>> permutations;
        vector<int> sol;
        dfs(nums, 0, permutations);
        return permutations;
    }
    
private:
    void dfs(vector<int>& nums, int lvl, vector<vector<int>>& permutations) {
        if (lvl == nums.size()) {
            permutations.push_back(nums);
            return;
        }
        
        for (int i = lvl; i < nums.size(); i++) {
            swap(nums, lvl, i);
            dfs(nums, lvl + 1, permutations);
            swap(nums, lvl, i);
        }
    }
    
    void swap(vector<int>& nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
};