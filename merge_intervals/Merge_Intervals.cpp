class Merge_Intervals {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if (intervals.empty() || intervals[0].empty()) {
            return vector<vector<int>>(1, vector<int>());
        }
        
        map<int, int> segments;
        for (auto& interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            map<int, int>::iterator floor = segments.lower_bound(start);
            if (floor != segments.begin()) {
                floor--;
                if (floor->second >= start) {
                    end = max(end, floor->second);
                    start = floor->first;
                    segments.erase(floor->first);
                }
            }
            
            map<int, int>::iterator ceil = segments.lower_bound(start);
            while (ceil != segments.end() && ceil->first <= end) {
                end = max(end, ceil->second);
                segments.erase(ceil->first);
                ceil = segments.upper_bound(start);
            }
            
            segments.insert({start, end});
        }
        
        vector<vector<int>> merged_intervals(segments.size(), vector<int>(2));
        int idx = 0;
        for (auto& interval : segments) {
            merged_intervals[idx++] = {interval.first, interval.second};
        }
        
        return merged_intervals;
    }
};