class RemoveAllAdjacentDuplicatedInStringII {
    // tc: O(nk); sc: O(1)
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0 || k == 1) {
            return "";
        }
        if (s.length() < 2 || k < 1) {
            return s;
        }

        char[] chs = s.toCharArray();
        int len = 0;
        for (int fast = 0; fast < chs.length; fast++) {
            chs[len] = chs[fast];
            int slow = len;
            while (slow - 1 >= 0 && chs[slow - 1] == chs[fast]) {
                slow--;
            }
            if (len - slow + 1 >= k) {
                len = slow;
            } else {
                len++;
            }
        }

        return s.subString(0, len);
    }

    // tc: O(n); sc: O(n)
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0 || k == 1) {
            return "";
        }
        if (s.length() < 2 || k < 1) {
            return s;
        }

        Deque<Character> chStack = new ArrayDeque<>();
        Deque<int[]> counterStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (chStack.isEmpty() || chStack.peekFirst() != ch) {
                chStack.offerFirst(ch);
                counterStack.offerFirst(new int[]{1});
                continue;
            }
            if (++counterStack.peekFirst()[0] == k) {
                chStack.pollFirst();
                counterStack.pollFirst();
            }
        } 

        StringBuilder sb = new StringBuilder();
        while (!chStack.isEmpty()) {
            int counter = counterStack.pollLast()[0];
            char ch = chStack.pollLast();
            for (int i = 0; i < counter; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}