class Subarray_Sum_Equals_K {
public:
    int subarraySum(vector<int>& nums, int k) {
        if (nums.empty()) {
            return 0;
        }
        
        unordered_map<int, int> table;
        table[0] = 1;
        int prefix_sum = 0;
        int num_subarray_sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            prefix_sum += nums[i];
            if (table.find(prefix_sum - k) != table.end()) {
                num_subarray_sum += table[prefix_sum - k];
            }
            table[prefix_sum]++;
        }
        
        return num_subarray_sum;
    }
};