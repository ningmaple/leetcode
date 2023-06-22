class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> permutations = new ArrayList<>();
        dfs(nums, 0, permutations);
        return permutations;
    }
    
    private void dfs(int[] nums, int lvl, List<List<Integer>> permutations) {
        if (lvl == nums.length) {
            permutations.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        
        for (int i = lvl; i < nums.length; i++) {
            swap(nums, lvl, i);
            dfs(nums, lvl + 1, permutations);
            swap(nums, lvl, i);
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}