class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if ((s == null && t == null) || s.equals(t) || Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        
        int sptr = 0;
        int tptr = 0;
        while (sptr < s.length() && tptr < t.length()) {
            char sCh = s.charAt(sptr++);
            char tCh = t.charAt(tptr++);
            if (sCh == tCh) {
                continue;
            }
            return s.substring(sptr).equals(t.substring(tptr)) || s.substring(sptr).equals(t.substring(tptr - 1)) || s.substring(sptr - 1).equals(t.substring(tptr));
        }
        
        return true;
    }
}