public class AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        int left = Math.max(m, 0);
        int right = Math.min(n, 9);
        if (left > right) {
            return 0;
        }
        
        Map<Integer, int[]> childrenToParent = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            childrenToParent.put(i, new int[]{i});
        }
        union(childrenToParent, 1, 3);
        union(childrenToParent, 1, 7);
        union(childrenToParent, 1, 9);
        union(childrenToParent, 2, 8);
        union(childrenToParent, 4, 6);
        
        Set<Integer> visited = new HashSet<>();
        int[] counter = new int[]{0};
        for (int num = 1; num <= 9; num++) {
            dfs(num, 1, left, right, childrenToParent, visited, counter);
        }
        
        return counter[0];
    }
    
    private void dfs(int num, int keyCounter, int left, int right, Map<Integer, int[]> childrenToParent, Set<Integer> visited, int[] counter) {
        if (keyCounter > right) {
            return;
        }
        
        if (keyCounter >= left) {
            counter[0]++;
        }

        visited.add(num);
        for (int nextNum = 1; nextNum <= 9; nextNum++) {
            if (visited.contains(nextNum) || (connected(childrenToParent, nextNum, num) && !visited.contains((nextNum + num) / 2))) {
                continue;
            }
            dfs(nextNum, keyCounter + 1, left, right, childrenToParent, visited, counter);
        }
        
        visited.remove(num);
    }
    
    private int find(Map<Integer, int[]> childrenToParent, int child) {
        int parent = child;
        while (childrenToParent.get(parent)[0] != parent) {
            parent = childrenToParent.get(parent)[0];
        }
        childrenToParent.get(child)[0] = parent;
        return parent;
    }
    
    private void union(Map<Integer, int[]> childrenToParent, int child1, int child2) {
        int parent1 = find(childrenToParent, child1);
        int parent2 = find(childrenToParent, child2);
        childrenToParent.get(parent1)[0] = Math.min(parent1, parent2);
        childrenToParent.get(parent2)[0] = Math.min(parent1, parent2);
    }
    
    private boolean connected(Map<Integer, int[]> childrenToParent, int child1, int child2) {
        return find(childrenToParent, child1) == find(childrenToParent, child2);
    }
}