public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return 0;
        }
        
        int validWords = 0;
        for (int i = 0; i < words.length; i++) {
            if (isValid(s, words[i])) {
                validWords++;
            }
        }
        
        return validWords;
    }
    
    private boolean isValid(String s, String word) {
        for (int wptr = 0, sptr = 0; wptr < word.length(); wptr++, sptr++) {
            char w = word.charAt(wptr);
            int wEnd = wptr;
            while (wEnd + 1 < word.length() && word.charAt(wEnd + 1) == w) {
                wEnd++;
            }
            int wCounter = wEnd - wptr + 1;
            wptr = wEnd;
            
            int sEnd = sptr;
            while (sEnd + 1 < s.length() && s.charAt(sEnd + 1) == w) {
                sEnd++;
            }
            int sCounter = sEnd - sptr + 1;
            sptr = sEnd;
            
            if (sCounter < wCounter || 
                (sCounter < 3 && sCounter != wCounter) || 
                (wEnd == word.length() -1 && sEnd < s.length() - 1) || 
                (wEnd < word.length() -1 && sEnd == s.length() - 1)) {
                return false;
            }
        }
        
        return true;
    }
}