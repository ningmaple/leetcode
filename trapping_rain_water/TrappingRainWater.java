public class TrappingRainWater {
    public int trap(int[] heights) {
        if (heights == null || heights.length < 3) {
            return 0;
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offer(0);
        int water = 0;
        for (int idx = 1; idx < heights.length; idx++) {
            int height = heights[idx];
            while (!stack.isEmpty() && heights[stack.peekFirst()] <= height) {
                int lowestLvlIdx = stack.pollFirst();
                if (stack.isEmpty()) {
                    continue;
                }
                water += (Math.min(heights[stack.peekFirst()], height) - heights[lowestLvlIdx]) * (idx - stack.peekFirst() - 1);
            }
            stack.offerFirst(idx);
        }
        
        return water;
    }
}