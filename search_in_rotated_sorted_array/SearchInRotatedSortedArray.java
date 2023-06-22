class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] > nums[left]) {
                if (nums[mid] < target || nums[left] > target) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] > target || nums[left] <= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
