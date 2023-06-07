class ZigZag_Conversion {
public:
    string convert(string s, int numRows) {
        if (s.size() < 2 || numRows < 2) {
            return s;
        }

        string ans(s);
        int idx = 0;
        for (int line = 0; line < numRows; line++) {
            for (int group = 0; line + group * (2 * numRows - 2) < s.size(); group++) {
                ans[idx++] = s[line + group * (2 * numRows - 2)];
                if (line == 0 || line == numRows - 1 || (group + 1) * (2 * numRows - 2) - line >= s.size()) {
                    continue;
                }
                ans[idx++] = s[(group + 1) * (2 * numRows - 2) - line];
            }
        }

        return ans;
    } 
};