public class FindAndReplaceinString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (indices == null || indices.length == 0 || sources == null || sources.length != indices.length || targets == null || targets.length != sources.length) {
            return s;
        }
        
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            idxMap.put(indices[i], i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int ptr = 0; ptr < s.length(); ptr++) {
            if (!idxMap.containsKey(ptr)) {
                sb.append(s.charAt(ptr));
                continue;
            }
            
            int idx = idxMap.get(ptr);
            String src = sources[idx];
            String dest = targets[idx];
            int start = ptr;
            int end = ptr + src.length() - 1;
            if (isValid(s, src, start, end)) {
                sb.append(dest);
                ptr = end;
            } else {
                sb.append(s.charAt(ptr));
            }
        }
        
        return sb.toString();
    }
    
    private boolean isValid(String s, String pattern, int start, int end) {
        for (int i = 0; i < pattern.length(); i++) {
            if (s.charAt(i + start) != pattern.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}