public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> missingRanges = new ArrayList<List<Integer>>();
        if (lower > upper) {
            return missingRanges;
        }
        if (nums == null || nums.length == 0) {
            missingRanges.add(Arrays.asList(lower, upper));
            return missingRanges;
        }
        
        TreeMap<Integer, Integer> ranges = new TreeMap<>();
        ranges.put(lower, upper);
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Map.Entry<Integer, Integer> floor = ranges.floorEntry(num);
            if (floor != null && floor.getValue() >= num) {
                ranges.remove(floor.getKey());
                int ll = floor.getKey();
                int lr = num - 1;
                int rl = num + 1;
                int rr = floor.getValue();
                if (ll <= lr) {
                    ranges.put(ll, lr);
                }
                if (rl <= rr) {
                    ranges.put(rl, rr);
                }
            }
            
            Map.Entry<Integer, Integer> ceil = ranges.ceilingEntry(num);
            if (ceil != null && ceil.getKey() == num) {
                ranges.remove(ceil);
                int l = ceil.getKey() + 1;
                int r = ceil.getValue();
                if (l <= r) {
                    ranges.put(l, r);
                }
            }
        }
        
        for (Map.Entry<Integer, Integer> range : ranges.entrySet()) {
            missingRanges.add(Arrays.asList(range.getKey(), range.getValue()));
        }
        return missingRanges;
    }
}