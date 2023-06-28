class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k >= num.length()) {
            return "0";
        }
        if (k < 1) {
            return num;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peekFirst() > digit && k-- > 0) {
                stack.pollFirst();
            }
            stack.offerFirst(digit);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.size() > k) {
            if (sb.length() == 0 && stack.peekLast() == 0) {
                stack.pollLast();
                continue;
            }
            sb.append(stack.pollLast());
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }
}