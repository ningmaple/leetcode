class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int prefixSum = 0;
        int numSubarray = 0;
        Map<Integer, int[]> table = new HashMap<>();
        table.put(prefixSum, new int[]{1});
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (table.containsKey(prefixSum - k)) {
                numSubarray += table.get(prefixSum - k)[0];
            }
            if (!table.containsKey(prefixSum)) {
                table.put(prefixSum, new int[]{0});
            }
            table.get(prefixSum)[0]++;
        }
        
        return numSubarray;
    }
}