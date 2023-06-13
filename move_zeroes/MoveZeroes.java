class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        int slow = 0; 
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == 0) {
                continue;
            }
            nums[slow++] = nums[fast];
        }
        
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}