public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            new ArrayList<List<Integer>>();
        }
        
        Arrays.sort(nums);
        List<List<Integer>> threeSumList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                    continue;
                }
                if (nums[left] + nums[right] > target) {
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] == target) {
                    threeSumList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
                
                left++;
                while (left < right && nums[left - 1] == nums[left]) {
                    left++;
                }
            }
            
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        
        return threeSumList;
    }
}