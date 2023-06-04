class Cell {
private:
    int x;
    int y;
public:
    Cell(int x, int y) : x(x), y(y) {}
    bool operator==(Cell const& cell) const {
        return this->x == cell.x && this->y == cell.y;
    }
    friend class my_hash;
    friend class Number_Of_Islands;
};

class my_hash {
public:
    size_t operator()(Cell const& cell) const noexcept {
        return cell.x * 101 + cell.y;
    }
};

class Number_Of_Islands {
private:
    void dfs(vector<vector<char>>& grid, vector<vector<int>>& dirs, Cell& cell, unordered_set<Cell, my_hash>& visited) {
        visited.insert(cell);
        for (auto dir : dirs) {
            int new_x = cell.x + dir[0];
            int new_y = cell.y + dir[1];
            if (new_x < 0 || new_x >= grid.size() || new_y < 0 || new_y >= grid[new_x].size() || grid[new_x][new_y] == '0') {
                continue;   
            }
            
            Cell nei(new_x, new_y);
            if (visited.find(nei) == visited.end()) {
                dfs(grid, dirs, nei, visited);    
            }
        }
    }
    
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.empty()) {
            return 0;
        }
        
        vector<vector<int>> dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        unordered_set<Cell, my_hash> visited;
        int counter = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[i].size(); j++) {
                Cell cell(i, j);
                if (grid[i][j] == '1' && visited.find(cell) == visited.end()) {
                    dfs(grid, dirs, cell, visited);
                    counter++;
                }
            }
        }
        
        return counter;
    }
};