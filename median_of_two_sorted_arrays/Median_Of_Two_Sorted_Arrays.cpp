class Median_Of_Two_Sorted_Arrays {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.empty() && nums2.empty()) {
            return 0;
        }
        
        int size = nums1.size() + nums2.size();
        if (size % 2 == 0) {
            double left = (double)findMedianSortedArrays(nums1, 0, nums2, 0, size / 2);
            double right = (double)findMedianSortedArrays(nums1, 0, nums2, 0, size / 2 + 1);
            return (left + right) / 2;
        }
        
        return (double)findMedianSortedArrays(nums1, 0, nums2, 0, size / 2 + 1);
    }

private:
    int findMedianSortedArrays(vector<int>& nums1, int ptr1, vector<int>& nums2, int ptr2, int k) {
        if (ptr1 >= nums1.size()) {
            return nums2[ptr2 + k - 1];
        }
        if (ptr2 >= nums2.size()) {
            return nums1[ptr1 + k - 1];
        }
        if (k == 1) {
            return min(nums1[ptr1], nums2[ptr2]);
        }
        
        int mid1 = ptr1 + k / 2 - 1;
        int mid2 = ptr2 + k / 2 - 1;
        int mid_val1 = mid1 >= nums1.size() ? INT_MAX : nums1[mid1];
        int mid_val2 = mid2 >= nums2.size() ? INT_MAX : nums2[mid2];
        
        return mid_val1 < mid_val2 ? findMedianSortedArrays(nums1, mid1 + 1, nums2, ptr2, k - k / 2) : findMedianSortedArrays(nums1, ptr1, nums2, mid2 + 1, k - k / 2);
    }
};
