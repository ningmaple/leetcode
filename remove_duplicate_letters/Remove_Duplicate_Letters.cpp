class Remove_Duplicate_Letters {
public:
    string smallestSubsequence(string s) {
        if (s.empty()) {
            return "";
        }

        unordered_map<char, int> positions;
        for (int i = 0; i < s.size(); i++) {
            positions[s[i]] = i;
        }

        unordered_set<char> visited;
        deque<char> deq;
        for (int i = 0; i < s.size(); i++) {
            if (visited.find(s[i]) != visited.end()) {
                continue;
            }

            while (!deq.empty() && deq.front() - 'a' > s[i] - 'a' && positions[deq.front()] > i) {
                visited.erase(deq.front());
                deq.pop_front();
            }

            deq.push_front(s[i]);
            visited.insert(s[i]);
        }

        string subseq = "";
        while (!deq.empty()) {
            subseq.push_back(deq.back());
            deq.pop_back();
        }
        return subseq;
    }
};