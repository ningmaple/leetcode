class ShortestPathInAGridWithObstaclesElimination {
    private class Cell {
        private int x;
        private int y;
        private int k;
        public Cell(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        k = Math.max(0, k);
        Queue<Cell> q = new ArrayDeque<>();
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                visited[i][j] = -1;
            }
        }

        Cell start = new Cell(0, 0, 0);
        q.offer(start);
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Cell curr = q.poll();
                if (curr.x == grid.length - 1 && curr.y == grid[0].length - 1) {
                    return curr.k <= k ? steps : -1;
                }

                visited[curr.x][curr.y] = curr.k;
                List<Cell> neighbors = getNeighbors(grid, k, curr, dirs, visited);
                for (Cell nei : neighbors) {
                    if (visited[nei.x][nei.y] != -1 && visited[nei.x][nei.y] <= nei.k) {
                        continue;
                    }
                    q.offer(nei);
                    visited[nei.x][nei.y] = nei.k;
                }
            }

            steps++;
        }

        return -1;
    }

    private List<Cell> getNeighbors(int[][] grid, int k, Cell curr, int[][] dirs, int[][] visited) {
        List<Cell> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int newX = curr.x + dir[0];
            int newY = curr.y + dir[1];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[newX].length) {
                continue;
            }

            int newK = grid[newX][newY] == 1 ? curr.k + 1 : curr.k;
            if (newK > k || (visited[newX][newY]) != -1 && visited[newX][newY] <= newK) {
                continue;
            }
            Cell nei = new Cell(newX, newY, newK);
            neighbors.add(nei);
        }
        return neighbors;
    }
}