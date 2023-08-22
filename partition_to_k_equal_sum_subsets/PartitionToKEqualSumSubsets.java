class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return false;
        }

        long targetSum = 0;
        for (int i = 0; i < nums.length; i++) {
            targetSum += nums[i];
        }
        if (targetSum % k != 0) {
            return false;
        }
        
        return dfs(nums, new boolean[nums.length], 0, 0, k, 0, (int)(targetSum / (long)k));
    }

    private boolean dfs(int[] nums, boolean[] visited, int idx, int group, int targetGroup, int currSum, int targetSum) {
        if (group == targetGroup) {
            return true;
        }
        if (currSum == targetSum) {
            return dfs(nums, visited, 0, group + 1, targetGroup, 0, targetSum);
        }
        if (currSum > targetSum) {
            return false;
        }

        for (int i = idx; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }            
            visited[i] = true;
            if (dfs(nums, visited, i + 1, group, targetGroup, currSum + nums[i], targetSum)) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }
}