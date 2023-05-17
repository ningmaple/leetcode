public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        boolean[] dpTable = new boolean[nums.length];
        dpTable[0] = true;
        for (int i = 1; i < dpTable.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dpTable[j] && nums[j] >= i - j) {
                    dpTable[i] = true;
                    break;
                }
            }
        }
        
        return dpTable[nums.length - 1];
    }
}