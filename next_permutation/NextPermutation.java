public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        int ptr = nums.length - 2;
        while (ptr >= 0 && nums[ptr + 1] <= nums[ptr]) {
            ptr--;
        }
        if (ptr == -1) {
            reverseArray(nums, 0, nums.length - 1);
            return;
        }
        
        int pivot = nums[ptr];
        int idx = findPivot(nums, ptr, pivot);
        swap(nums, ptr, idx);
        reverseArray(nums, ptr + 1, nums.length - 1);
    }
    
    private void reverseArray(int[] nums, int left, int right) {
        while (left <= right) {
            swap(nums, left++, right--);
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    
    private int findPivot(int[] nums, int start, int pivot) {
        int ptr = nums.length - 1;
        while (ptr >= start) {
            if (nums[ptr] > pivot) {
                return ptr;
            }
            ptr--;
        }
        return -1;
    }
}