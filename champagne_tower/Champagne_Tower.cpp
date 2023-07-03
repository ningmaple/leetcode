class Champagne_Tower {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        if (poured < 1 || query_row < 0 || query_glass > query_row) {
            return 0;
        }

        double dpTable[query_row + 1][query_row + 1];
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= query_row; j++) {
                dpTable[i][j] = 0;
            }
        }

        dpTable[0][0] = (double)poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dpTable[i][j] <= 1) {
                    continue;
                }
                dpTable[i + 1][j] += (dpTable[i][j] - 1) / 2;
                dpTable[i + 1][j + 1] += (dpTable[i][j] - 1) / 2;
            }
        }

        return min(1.0, dpTable[query_row][query_glass]);
    }
};