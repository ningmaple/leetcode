class Find_Common_Characters {
public:
    vector<string> commonChars(vector<string>& words) {
        if (words.empty()) {
            return vector<string>();
        }

        unordered_map<char, int> commons_counter;
        for (int i = 0; i < words[0].size(); i++) {
            commons_counter[words[0][i]]++;
        }

        for (int i = 1; i < words.size(); i++) {
            unordered_map<char, int> curr_counter;
            for (int j = 0; j < words[i].size(); j++) {
                curr_counter[words[i][j]]++;
            }

            for (auto& counter : commons_counter) {
                if (curr_counter.find(counter.first) == curr_counter.end()) {
                    counter.second = 0;
                    continue;
                }
                counter.second = min(counter.second, curr_counter[counter.first]);
            }
        }

        vector<string> common_chars;
        for (auto& counter : commons_counter) {
            for (int i = 0; i < counter.second; i++) {
                common_chars.push_back(string(1, counter.first));
            }
        }
        return common_chars;
    }
};