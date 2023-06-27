class PathSumIV {
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Map<Integer, Integer>> nodes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] details = getDetails(nums[i]);
            if (!nodes.containsKey(details[0])) {
                nodes.put(details[0], new HashMap<>());
            }
            nodes.get(details[0]).put(details[1] - 1, details[2]);
        }

        int[] sum = new int[]{0};
        dfs(nodes, 1, 0, 0, sum);
        return sum[0];
    }

    private void dfs(Map<Integer, Map<Integer, Integer>> nodes, int x, int y, int currSum, int[] sum) {
        currSum += nodes.get(x).get(y);
        if (!nodes.containsKey(x + 1) || (!nodes.get(x + 1).containsKey(2 * y) && !nodes.get(x + 1).containsKey(2 * y + 1))) {
            sum[0] += currSum;
            return;
        }
        
        if (nodes.get(x + 1).containsKey(2 * y)) {
            dfs(nodes, x + 1, 2 * y, currSum, sum);
        }
        if (nodes.get(x + 1).containsKey(2 * y + 1)) {
            dfs(nodes, x + 1, 2 * y + 1, currSum, sum);
        }
    }

    private int[] getDetails(int num) {
        int[] details = new int[3];
        for (int i = 2; i >= 0; i--) {
            details[i] = num % 10;
            num /= 10;
        }

        return details;
    }
}