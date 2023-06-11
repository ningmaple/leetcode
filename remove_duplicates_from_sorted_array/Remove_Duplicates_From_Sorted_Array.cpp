class Remove_Duplicates_From_Sorted_Array {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) {
            return 0;
        }
        
        int slow = 1;
        for (int fast = 1; fast < nums.size(); fast++) {
            if (nums[fast] == nums[slow - 1]) {
                continue;
            }
            swap(nums, slow++, fast);
        }
        
        return slow;
    }

private:
    void swap(vector<int>& nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
};