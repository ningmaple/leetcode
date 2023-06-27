class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> positions = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            positions.put(s.charAt(i), i);
        }

        Deque<Character> deq = new ArrayDeque<>();
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (seen.contains(ch)) {
                continue;
            }

            while (!deq.isEmpty() && deq.peekFirst() - 'a' > ch - 'a' && positions.get(deq.peekFirst()) > i) {
                seen.remove(deq.pollFirst());
            }
            deq.offerFirst(ch);
            seen.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!deq.isEmpty()) {
            sb.append(deq.pollLast());
        }
        return sb.toString();
    }
}