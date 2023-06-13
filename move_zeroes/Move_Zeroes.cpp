class Move_Zeroes {
public:
    void moveZeroes(vector<int>& nums) {
        if (nums.empty() || nums.size() < 2) {
            return;
        }
        
        int ptr = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                nums[ptr++] = nums[i];
            }
        }
        for (; ptr < nums.size(); ptr++) {
            nums[ptr] = 0;
        }
    }
};