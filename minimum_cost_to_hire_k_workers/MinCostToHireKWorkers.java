public class MinCostToHireKWorkers {
    private static class Worker {
        private final int id;
        private final int quality;
        private final int wage;
        private final double score;
        public Worker(int id, int quality, int wage) {
            this.id = id;
            this.quality = quality;
            this.wage = wage;
            this.score = (double)wage / (double)quality;
        }
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        if (quality == null || quality.length == 0 || wage == null || quality.length != wage.length || k > quality.length) {
            return 0;
        }
        
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            int id = i;
            int q = quality[i];
            int w = wage[i];
            workers[i] = new Worker(id, q, w);
        }
        Arrays.sort(workers, new Comparator<Worker>() {
            @Override
            public int compare(Worker w1, Worker w2) {
                if (w1.score < w2.score) {
                    return -1;
                }
                if (w1.score > w2.score) {
                    return 1;
                }
                if (w1.quality > w2.quality) {
                    return -1;
                }
                if (w1.quality < w2.quality) {
                    return 1;
                }
                return 0;
            }
        });

        PriorityQueue<Worker> maxHeap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Worker w1, Worker w2) {
                if (w1.quality > w2.quality) {
                    return -1;
                }
                if (w1.quality < w2.quality) {
                    return 1;
                }
                return 0;
            }
        });
        
        long totalQuality = 0;
        double cost = Integer.MAX_VALUE;
        for (Worker worker : workers) {
            if (maxHeap.size() < k - 1) {
                totalQuality += worker.quality;
                maxHeap.offer(worker);
                continue;
            }

            cost = Math.min(cost, (totalQuality + worker.quality) * worker.score);
            if (!maxHeap.isEmpty() && maxHeap.peek().quality > worker.quality) {
                totalQuality += worker.quality - maxHeap.poll().quality;
                maxHeap.offer(worker);
            }
        }
        
        return cost;
    }
}