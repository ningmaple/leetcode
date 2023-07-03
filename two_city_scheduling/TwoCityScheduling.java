class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int totalCost = 0;
        for (int i = 0; i < costs.length; i++) {
            costs[i][1] -= costs[i][0];
            totalCost += costs[i][0];
        }
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return 0;
                }
                return o1[1] < o2[1] ? -1 : 1;
            }
        });

        for (int i = 0; i < costs.length / 2; i++) {
            totalCost += costs[i][1];
        }

        return totalCost;
    }
}