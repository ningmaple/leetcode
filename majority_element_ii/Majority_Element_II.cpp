class Majority_Element_II {
public:
    vector<int> majorityElement(vector<int>& nums) {
        if (nums.empty()) {
            return vector<int>();
        }
        
        int candidate_[2] = {INT_MAX, INT_MAX};
        int counter_[2] = {0, 0};
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == candidate_[0]) {
                counter_[0]++;
                continue;
            }
            if (nums[i] == candidate_[1]) {
                counter_[1]++;
                continue;
            }
            if (counter_[0] == 0) {
                counter_[0] = 1;
                candidate_[0] = nums[i];
                continue;
            }
            if (counter_[1] == 0) {
                counter_[1] = 1;
                candidate_[1] = nums[i];
                continue;
            }
        
            counter_[0]--;
            counter_[1]--;
        }

        vector<int> major_elements;
        int counter_post_[2] = {0, 0};
        for (auto num : nums) {
            if (num == candidate_[0]) {
                counter_post_[0]++;
            } else if (num == candidate_[1]) {
                counter_post_[1]++;
            }
        }
        if (counter_post_[0] > nums.size() / 3) {
            major_elements.push_back(candidate_[0]);
        }        
        if (counter_post_[1] > nums.size() / 3) {
            major_elements.push_back(candidate_[1]);
        }
        return major_elements;
    }
};