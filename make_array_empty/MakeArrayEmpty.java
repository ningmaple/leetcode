class MakeArrayEmpty {
    public long countOperationsToEmptyArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        TreeMap<Integer, Integer> table = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            table.put(nums[i], i);
        }

        Map.Entry<Integer, Integer> first = table.firstEntry();
        int lastPosition = first.getValue();
        long steps = nums.length;
        table.remove(first.getKey());
        int idx = 1;
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            if (entry.getValue() < lastPosition) {
                steps += nums.length - idx;
            }
            lastPosition = entry.getValue();
            idx++;
        }

        return steps;
    }
}