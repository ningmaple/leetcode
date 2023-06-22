class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return new int[1][0];
        }
        
        TreeMap<Integer, Integer> segments = new TreeMap<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            Map.Entry<Integer, Integer> floor = segments.floorEntry(start);
            if (floor != null && floor.getValue() >= start) {
                segments.remove(floor.getKey());
                start = floor.getKey();
                end = Math.max(end, floor.getValue());
            }
            
            Map.Entry<Integer, Integer> ceil = segments.ceilingEntry(start);
            while (ceil != null && ceil.getKey() <= end) {
                segments.remove(ceil.getKey());
                end = Math.max(end, ceil.getValue());
                ceil = segments.ceilingEntry(start);
            }
            
            segments.put(start, end);
        }
        
        int[][] mergedIntervals = new int[segments.size()][];
        int idx = 0;
        for (Map.Entry<Integer, Integer> interval : segments.entrySet()) {
            mergedIntervals[idx++] = new int[]{interval.getKey(), interval.getValue()};
        }
        
        return mergedIntervals;
    }
}