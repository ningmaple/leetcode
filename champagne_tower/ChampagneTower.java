class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured < 1 || query_row < 0 || query_glass < 0 || query_glass > query_row + 1) {
            return 0;
        }

        double[][] dpTable = new double[query_row + 1][query_row + 1];
        dpTable[0][0] = (double)poured;
        for (int i = 0; i < dpTable.length - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (dpTable[i][j] > 1.0) {
                    dpTable[i + 1][j] += (dpTable[i][j] - 1) / 2.0;
                    dpTable[i + 1][j + 1] += (dpTable[i][j] - 1) / 2.0;
                }
            }
        }

        return Math.min(1.0, dpTable[query_row][query_glass]);
    }
}