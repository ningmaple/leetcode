class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        if (n < 1) {
            return new ArrayList<String>();
        }
        
        Map<Integer, Integer> pairs = new HashMap<>();
        Set<Integer> uniques = new HashSet<>();
        pairs.put(0, 0);
        pairs.put(1, 1);
        pairs.put(6, 9);
        pairs.put(8, 8);
        pairs.put(9, 6);
        uniques.add(0);
        uniques.add(1);
        uniques.add(8);
        
        int[] sol = new int[n];
        List<String> strobogrammaticNums = new ArrayList<>();
        dfs(sol, pairs, uniques, 0, n - 1, strobogrammaticNums);

        return strobogrammaticNums;
    }
    
    private void dfs(int[] sol, Map<Integer, Integer> pairs, Set<Integer> uniques, int left, int right, List<String> strobogrammaticNums) {
        if (left > right) {
            if (sol.length > 1 && sol[0] == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int digit : sol) {
                sb.append(digit);
            }
            strobogrammaticNums.add(sb.toString());
            return;
        }
        if (left == right) {
            for (int digit : uniques) {
                sol[left] = digit;
                dfs(sol, pairs, uniques, left + 1, right - 1, strobogrammaticNums);
            }
            return;
        }
        
        for (Map.Entry<Integer, Integer> pair : pairs.entrySet()) {
            sol[left] = pair.getKey();
            sol[right] = pair.getValue();
            dfs(sol, pairs, uniques, left + 1, right - 1, strobogrammaticNums);
        }
    } 
}