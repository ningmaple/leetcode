public class NextClosestTime {
    public String nextClosestTime(String time) {
        if (time == null || time.length() != 5) {
            return "";
        }
        
        int[] digits = new int[4];
        int idx = 0;
        for (int i = 0; i < time.length(); i++) {
            char ch = time.charAt(i);
            if (ch == ':') {
                continue;
            }
            digits[idx++] = ch - '0';
        }
        
        List<int[]> times = new ArrayList<>();
        dfs(digits, 0, new int[4], times);
        int target = covert(digits);
        int delta = Integer.MAX_VALUE;
        String cloest = null;
        for (int i = 0; i < times.size(); i++) {
            int[] t = times.get(i);
            if (t[0] * 10 + t[1] > 23 || t[2] * 10 + t[3] > 59) {
                continue;
            }
            
            String currTime = getTime(t);
            if (time.equals(currTime)) {
                continue;
            }
            int curr = covert(t);
            if (curr - target > 0 && curr - target < delta) {
                delta = curr - target;
                cloest = currTime;
            }
            if (curr - target < 0 && curr - target + 24 * 60 < delta) {
                delta = curr - target + 24 * 60;
                cloest = currTime;
            }
        }
        
        return cloest == null ? time : cloest;
    }
    
    private String getTime(int[] time) {
        StringBuilder sb = new StringBuilder();
        sb.append(time[0]).append(time[1]).append(":").append(time[2]).append(time[3]);
        return sb.toString();
    }
    
    private void dfs(int[] digits, int lvl, int[] sol, List<int[]> times) {
        if (lvl == digits.length) {
            times.add(new int[]{sol[0], sol[1], sol[2], sol[3]});
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            sol[lvl] = digits[i];
            dfs(digits, lvl + 1, sol, times);
        }
    }   
    
    private int covert(int[] time) {
        return (time[0] * 10 + time[1]) * 60 + time[2] * 10 + time[3];
    }
}