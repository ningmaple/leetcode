public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0 || k < 1) {
            return new int[0][2];
        }
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double dist1 = getDist(o1);
                double dist2 = getDist(o2);
                if (dist1 == dist2) {
                    return 0;
                }
                return dist1 > dist2 ? -1 : 1;
            }
        });
        for (int[] point : points) {
            if (maxHeap.size() < k) {
                maxHeap.offer(point);
                continue;
            }
            
            double currMax = getDist(maxHeap.peek());
            double dist = getDist(point);
            if (dist < currMax) {
                maxHeap.poll();
                maxHeap.offer(point);
            }
        }
        
        int[][] kClosestPoints = new int[Math.min(k, maxHeap.size())][2];
        int idx = 0;
        while (!maxHeap.isEmpty()) {
            kClosestPoints[idx++] = maxHeap.poll();
        }
        return kClosestPoints;
    }
    
    private double getDist(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
}