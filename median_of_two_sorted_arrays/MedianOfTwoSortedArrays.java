class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        if (nums1 == null) {
            return findMedianSortedArrays(new int[0], nums2);
        }
        if (nums2 == null) {
            return findMedianSortedArrays(nums1, new int[0]);
        }
        
        int size = nums1.length + nums2.length;
        if (size % 2 == 0) {
            double left = (double)findMedianSortedArrays(nums1, 0, nums2, 0, size / 2);
            double right = (double)findMedianSortedArrays(nums1, 0, nums2, 0, size / 2 + 1);
            return (left + right) / 2;
        }
        
        return (double)findMedianSortedArrays(nums1, 0, nums2, 0, size / 2 + 1);
    }
    
    // 第k小, 1-idx
    private int findMedianSortedArrays(int[] nums1, int ptr1, int[]nums2, int ptr2, int k) {
        if (ptr1 >= nums1.length) {
            return nums2[ptr2 + k - 1];
        }
        if (ptr2 >= nums2.length) {
            return nums1[ptr1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[ptr1], nums2[ptr2]);
        }
        
        int mid1 = ptr1 + k / 2 - 1;
        int mid2 = ptr2 + k / 2 - 1;
        int mid1Val = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];
        int mid2Val = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];
        
        return mid1Val < mid2Val ? findMedianSortedArrays(nums1, mid1 + 1, nums2, ptr2, k - k / 2) : findMedianSortedArrays(nums1, ptr1, nums2, mid2 + 1, k - k / 2);
    }
}
