class Make_Array_Empty {
public:
    long long countOperationsToEmptyArray(vector<int>& nums) {
        if (nums.empty()) {
            return 0;
        }

        unordered_map<int, int> table;
        for (int i = 0; i < nums.size(); i++) {
            table[nums[i]] = i;
        }
        sort(nums.begin(), nums.end());

        long long steps = nums.size();
        for (int i = 1; i < nums.size(); i++) {
            if (table[nums[i]] >= table[nums[i - 1]]) {
                continue;
            }
            steps += nums.size() - i;
        }
        return steps;
    }
};