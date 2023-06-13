class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        
        long[] leftToRight = new long[nums.length];
        leftToRight[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftToRight[i] = nums[i] * leftToRight[i - 1];
        }
        
        long[] rightToLeft = new long[nums.length];
        rightToLeft[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightToLeft[i] = nums[i] * rightToLeft[i + 1];
        }
        
        int[] products = new int[nums.length];
        products[0] = (int)rightToLeft[1];
        products[nums.length - 1] = (int)leftToRight[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            products[i] = (int)(leftToRight[i - 1] * rightToLeft[i + 1]);
        }
        return products;
    }
}