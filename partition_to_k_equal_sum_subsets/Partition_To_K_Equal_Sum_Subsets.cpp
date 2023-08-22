class Partition_To_K_Equal_Sum_Subsets {
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        if (nums.empty() || nums.size() < k) {
            return false;
        }

        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }

        bool visited[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            visited[i] = false;
        }
        int target = (int)(sum / k);
        sort(nums.begin(), nums.end());
        return dfs(nums, visited, 0, 0, k, 0, target);
    }

private:
    bool dfs(vector<int>& nums, bool* visited, int idx, int group, int& target_group, int curr_sum, int& target_sum) {
        if (group == target_group) {
            return true;
        }
        if (curr_sum > target_sum) {
            return false;
        }
        if (curr_sum == target_sum) {
            return dfs(nums, visited, 0, group + 1, target_group, 0, target_sum);
        }

        int prev_num = INT_MIN;
        for (int i = idx; i < nums.size(); i++) {
            if (*(visited + i) || prev_num == nums[i]) {
                continue;
            }
            prev_num = nums[i];
            *(visited + i) = true;
            if (dfs(nums, visited, i + 1, group, target_group, curr_sum + nums[i], target_sum)) {
                return true;
            }
            *(visited + i) = false;
        }

        return false;
    }
};