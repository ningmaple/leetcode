class One_Edit_Distance {
public:
    bool isOneEditDistance(string s, string t) {
        if (s == t || abs((int)s.size() - (int)t.size()) > 1) {
            return false;
        }
        
        int sptr = 0;
        int tptr = 0;
        while (sptr < s.size() && tptr < t.size()) {
            if (s[sptr++] == t[tptr++]) {
                continue;
            }
            return s.substr(sptr) == t.substr(tptr) || s.substr(sptr - 1) == t.substr(tptr) || s.substr(sptr) == t.substr(tptr - 1);
        }
        
        return true;
    }
};