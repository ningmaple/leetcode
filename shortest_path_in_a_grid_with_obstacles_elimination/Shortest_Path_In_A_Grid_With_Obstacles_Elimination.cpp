class Cell {
private:
    int x;
    int y;
    int k;
public:
    Cell(int x, int y, int k) : x(x), y(y), k(k) {};
    bool operator==(const Cell& another) const {
        return this->x == another.x && this->y == another.y && this->k == another.k;
    }
    friend class Solution;
};

class Shortest_Path_In_A_Grid_With_Obstacles_Elimination {
private:
    vector<Cell> get_neighbors(vector<vector<int>>& grid, int k, Cell& curr, vector<vector<int>>& dirs, vector<vector<int>>& visited) {
        vector<Cell> neighbors;
        for (auto& dir : dirs) {
            int new_x = curr.x + dir[0];
            int new_y = curr.y + dir[1];
            if (new_x < 0 || new_x >= grid.size() || new_y < 0 || new_y >= grid[new_x].size()) {
                continue;
            }
            int new_k = grid[new_x][new_y] == 1 ? curr.k + 1 : curr.k;
            if (new_k > k || (visited[new_x][new_y] != -1 && visited[new_x][new_y] <= new_k)) {
                continue;
            }
            Cell nei(new_x, new_y, new_k);
            neighbors.push_back(nei);
        }

        return neighbors;
    }

public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        if (grid.empty() || grid[0].empty()) {
            return -1;
        }

        vector<vector<int>> visited(grid.size(), vector<int>(grid[0].size(), -1));
        queue<Cell> q;
        Cell start(0, 0, 0);
        q.push(start);
        vector<vector<int>> dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int steps = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Cell curr = q.front();
                q.pop();
                if (curr.x == grid.size() - 1 && curr.y == grid[grid.size() - 1].size() - 1) {
                    return steps;
                }

                visited[curr.x][curr.y] = curr.k;
                vector<Cell> neighbors = get_neighbors(grid, k, curr, dirs, visited);
                for (auto& nei : neighbors) {
                    q.push(nei);
                    visited[nei.x][nei.y] = nei.k;
                }
            }

            steps++;
        }

        return -1;
    }
};