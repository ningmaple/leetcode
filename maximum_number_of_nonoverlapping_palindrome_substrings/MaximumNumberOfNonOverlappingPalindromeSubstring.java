class MaximumNumberOfNonOverlappingPalindromeSubstrings {
    public int maxPalindromesI(String s, int k) {
        if (s == null || s.length() == 0 || k < 1) {
            return 0;
        }

        boolean[][] palindromes = checkPalindromes(s);
        int[] dpTable = new int[s.length() + 1];
        for (int right = k; right < dpTable.length; right++) {
            dpTable[right] = dpTable[right - 1];
            for (int left = 1; right - left + 1 >= k; left++) {
                if (palindromes[left - 1][right - 1]) {
                    dpTable[right] = Math.max(dpTable[right], dpTable[left - 1] + 1);
                }
            }
        }

        return dpTable[s.length()];
    }

    public int maxPalindromesII(String s, int k) {
        if (s == null || s.length() == 0 || k < 1) {
            return 0;
        }

        boolean[][] palindromes = checkPalindromes(s);
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < palindromes.length; i++) {
            for (int j = i + k - 1; j < palindromes[i].length; j++) {
                if (palindromes[i][j]) {
                    intervals.add(new int[]{i, j});
                }
            }
        }
        if (intervals.isEmpty()) {
            return 0;
        }

        Collections.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    if (o1[0] == o2[0]) {
                        return 0;
                    }
                    return o1[0] < o2[0] ? -1 : 1;
                }
                return o1[1] < o2[1] ? -1 : 1; 
            }
        });

        int removeCounter = 0;
        int endIdx = intervals.get(0)[1];
        for (int i = 1; i < intervals.size(); i++) {
            int[] curr = intervals.get(i);
            if (endIdx >= curr[0]) {
                removeCounter++;
                continue;
            }
            endIdx = curr[1];
        }

        return intervals.size() - removeCounter;
    }

    private boolean[][] checkPalindromes(String s) {
        boolean[][] palindromes = new boolean[s.length()][s.length()];
        for (int mid = 0; mid < s.length(); mid++) {
            int left = mid;
            int right = mid;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                palindromes[left--][right++] = true;
            }

            left = mid;
            right = mid + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                palindromes[left--][right++] = true;
            }
        }

        return palindromes;
    }
}