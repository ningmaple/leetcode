class Three_Sum {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        if (nums.empty() || nums.size() < 3) {
            return vector<vector<int>>();
        }
        
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        for (int i = 0; i < nums.size() - 2; i++) {           
            int left = i + 1;
            int right = nums.size() - 1;
            int target = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                    continue;
                } 
                if (nums[left] + nums[right] > target) {
                    right--;
                    continue;
                }
                
                ans.push_back({nums[i], nums[left], nums[right]});
                while (left + 1 < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                left++;
            }
            
            while (i + 1 < nums.size() - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        
        return ans;
    }
};