class Camelcase_Matching {
public:
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        if (queries.empty()) {
            return vector<bool>();
        }
        if (pattern.empty()) {
            return vector<bool>(queries.size(), false);
        }

        vector<bool> camel_matches;
        for (string& query : queries) {
            camel_matches.push_back(camel_match(query, pattern));
        }
        return camel_matches;
    }

private:
    bool camel_match(string& query, string& pattern) {
        int ptr_p = 0;
        int ptr_q = 0;
        while (ptr_q < query.size() && ptr_p < pattern.size()) {
            if (query[ptr_q] == pattern[ptr_p]) {
                ptr_p++;
                ptr_q++;
                continue;
            }
            if (isupper(query[ptr_q++])) {
                return false;
            }
        }
        while (ptr_q < query.size() && islower(query[ptr_q])) {
            ptr_q++;
        }

        return ptr_p == pattern.size() && ptr_q == query.size();
    }
};