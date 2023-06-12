class Merge_Sorted_Array {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if (nums1.empty() || nums2.empty() || nums2.size() != n ||  nums1.size() != m + n) {
            return;
        }
        
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int idx = nums1.size() - 1;
        while (ptr1 >= 0 && ptr2 >= 0) {
            if (nums1[ptr1] >= nums2[ptr2]) {
                nums1[idx--] = nums1[ptr1--];
                continue;
            }
            nums1[idx--] = nums2[ptr2--];
        }
        while (ptr2 < nums2.size()) {
            nums1[idx--] = nums2[ptr2--];
        }
    }
};