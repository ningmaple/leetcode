class Product_Of_Array_Except_Self {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        if (nums.empty()) {
            return vector<int>();
        }

        long left_to_right[nums.size() + 2];
        left_to_right[0] = 1;
        for (int i = 1; i < nums.size() + 1; i++) {
            left_to_right[i] = left_to_right[i - 1] * nums[i - 1];
        }
        
        long right_to_left[nums.size() + 2];
        right_to_left[nums.size() + 1] = 1;
        for (int i = nums.size(); i > 0; i--) {
            right_to_left[i] = right_to_left[i + 1] * nums[i - 1];
        }
        
        vector<int> products;
        for (int i = 0; i < nums.size(); i++) {
            products.push_back(left_to_right[i] * right_to_left[i + 2]);
        }
        return products;
    }
};