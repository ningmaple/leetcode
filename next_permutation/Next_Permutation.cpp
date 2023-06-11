class Next_Permutation {
public:
    void nextPermutation(vector<int>& nums) {
        if (nums.empty()) {
            return;
        }
        
        int ptr = nums.size() - 2;
        while (ptr >= 0 && nums[ptr] >= nums[ptr + 1]) {
            ptr--;
        }
        if (ptr == -1) {
            swap_all(nums, 0, nums.size() - 1);
            return;
        }

        swap(nums, ptr, find_target(nums, ptr + 1, nums.size() - 1, nums[ptr]));   
        swap_all(nums, ptr + 1, nums.size() - 1);
    }
    
private:
    int find_target(vector<int>& nums, int left, int right, int target) {
        if (left == right) {
            return left;
        }
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                right = mid;
                continue;
            }
            left = mid;
        }
        
        return nums[right] > target ? right : left;
    }
    
    void swap_all(vector<int>& nums, int left, int right) {
        while (left <= right) {
            swap(nums, left++, right--);
        }
    }
    
    void swap(vector<int>& nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
};