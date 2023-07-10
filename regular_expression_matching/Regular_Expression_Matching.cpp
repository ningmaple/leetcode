class Regular_Expression_Matching {
public:
    bool isMatch(string s, string p) {
        if (s.empty() && p.empty()) {
            return true;
        }
        
        bool dp_table[s.size() + 1][p.size() + 1];
        for (int i = 0; i <= s.size(); i++) {
            for (int j = 0; j <= p.size(); j++) {
                dp_table[i][j] = false;
            }
        }

        dp_table[0][0] = true;
        for (int i = 2; i <= p.size(); i++) {
            dp_table[0][i] = p[i - 1] == '*' && dp_table[0][i - 2];
        }
        
        for (int sptr = 1; sptr <= s.size(); sptr++) {
            for (int pptr = 1; pptr <= p.size(); pptr++) {
                if (isalpha(p[pptr - 1])) {
                    dp_table[sptr][pptr] = s[sptr - 1] == p[pptr - 1] && dp_table[sptr - 1][pptr - 1];
                    continue;
                }
                if (p[pptr - 1] == '.') {
                    dp_table[sptr][pptr] = dp_table[sptr - 1][pptr - 1];
                    continue;
                }
                
                dp_table[sptr][pptr] = dp_table[sptr][pptr - 2] || ((s[sptr - 1] == p[pptr - 2] || p[pptr - 2] == '.') && dp_table[sptr - 1][pptr]);
            }
        }
        
        return dp_table[s.size()][p.size()];
    }
};