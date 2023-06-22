class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), subsets);
        return subsets;
    }
    
    private void dfs(int[] nums, int lvl, List<Integer> sol, List<List<Integer>> subsets) {
        if (lvl == nums.length) {
            subsets.add(new ArrayList<Integer>(sol));
            return;
        }
        
        sol.add(nums[lvl]);
        dfs(nums, lvl + 1, sol, subsets);
        sol.remove(sol.size() - 1);
        dfs(nums, lvl + 1, sol, subsets);
    }
}