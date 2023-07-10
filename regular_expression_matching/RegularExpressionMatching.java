class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if (s == null || p == null) {
            return false;
        }
        
        boolean[][] dpTable = new boolean[s.length() + 1][p.length() + 1];
        dpTable[0][0] = true;
        for (int i = 2; i <= p.length(); i++) {
            dpTable[0][i] = p.charAt(i - 1) == '*' && dpTable[0][i - 2];
        }
        
        for (int sptr = 1; sptr < dpTable.length; sptr++) {
            for (int pptr = 1; pptr < dpTable[sptr].length; pptr++) {
                char sch = s.charAt(sptr - 1);
                char pch = p.charAt(pptr - 1);
                if (Character.isLetter(pch)) {
                    dpTable[sptr][pptr] = (sch == pch) && dpTable[sptr - 1][pptr - 1];
                    continue;
                }
                if (pch == '.') {
                    dpTable[sptr][pptr] = dpTable[sptr - 1][pptr - 1];
                    continue;
                }
                
                char ppch = p.charAt(pptr - 2);
                dpTable[sptr][pptr] = dpTable[sptr][pptr - 2] || ((sch == ppch || ppch == '.') && dpTable[sptr - 1][pptr]);
            }
        }
        
        return dpTable[s.length()][p.length()];
    }
}