class Two_City_Scheduling {    
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        if (costs.empty()) {
            return 0;
        }

        int min_cost = 0;
        for (int i = 0; i < costs.size(); i++) {
            min_cost += costs[i][0];
            costs[i][1] -= costs[i][0];
        }

        sort(costs.begin(), costs.end(), [](vector<int>& cost1, vector<int>& cost2) {
            return cost1[1] < cost2[1];
        });
        for (int i = 0; i < costs.size() / 2; i++) {
            min_cost += costs[i][1];
        }
        return min_cost;
    }
};