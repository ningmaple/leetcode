public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return false;
        }
        
        int sptr = s.length() - 1;
        int tptr = t.length() - 1;
        while (sptr >= 0 && tptr >= 0) {
            char sChar = s.charAt(sptr);
            char tChar = t.charAt(tptr);
            if (sChar == '#') {
                int counter = 1;
                sptr--;
                while (counter > 0 && sptr >= 0) {
                    sChar = s.charAt(sptr--);
                    if (sChar == '#') {
                        counter++;
                    } else {
                        counter--;
                    }
                }
                continue;
            }
            
            if (tChar == '#') {
                int counter = 1;
                tptr--;
                while (counter > 0 && tptr >= 0) {
                    tChar = t.charAt(tptr--);
                    if (tChar == '#') {
                        counter++;
                    } else {
                        counter--;
                    }
                }
                continue;
            }
            
            if (sChar == tChar) {
                tptr--;
                sptr--;
                continue;
            }
            return false;
        }
        
        while (sptr >= 0) {
            char sChar = s.charAt(sptr);
            if (sChar == '#') {
                int counter = 1;
                sptr--;
                while (counter > 0 && sptr >= 0) {
                    sChar = s.charAt(sptr--);
                    if (sChar == '#') {
                        counter++;
                    } else {
                        counter--;
                    }
                }
                continue;
            }
            break;
        }
        
        while (tptr >= 0) {
            char tChar = t.charAt(tptr);
            if (tChar == '#') {
                int counter = 1;
                tptr--;
                while (counter > 0 && tptr >= 0) {
                    tChar = t.charAt(tptr--);
                    if (tChar == '#') {
                        counter++;
                    } else {
                        counter--;
                    }
                }
                continue;
            }
            break;
        }
        
        return sptr < 0 && tptr < 0;
    }
}