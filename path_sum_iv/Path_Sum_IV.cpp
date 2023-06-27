class Path_Sum_IV {
public:
    int pathSum(vector<int>& nums) {
        if (nums.empty()) {
            return 0;
        }

        unordered_map<int, unordered_map<int, int>> nodes;
        for (int num : nums) {
            int lvl = num / 100;
            int idx = (num / 10) % 10 - 1;
            int val = num % 10;
            nodes[lvl][idx] = val;
        }

        int sum = 0;
        dfs(nodes, 1, 0, 0, sum);
        return sum;
    }

private:
    void dfs(unordered_map<int, unordered_map<int, int>>& nodes, int lvl, int idx, int curr_sum, int& sum) {
        curr_sum += nodes[lvl][idx];
        if (nodes.find(lvl + 1) == nodes.end() || (nodes[lvl + 1].find(2 * idx) == nodes[lvl + 1].end() && nodes[lvl + 1].find(2 * idx + 1) == nodes[lvl + 1].end())) {
            sum += curr_sum;
            return;
        }

        if (nodes[lvl + 1].find(2 * idx) != nodes[lvl + 1].end()) {
            dfs(nodes, lvl + 1, 2 * idx, curr_sum, sum);
        }
        if (nodes[lvl + 1].find(2 * idx + 1) != nodes[lvl + 1].end()) {
            dfs(nodes, lvl + 1, 2 * idx + 1, curr_sum, sum);
        }
    }
};