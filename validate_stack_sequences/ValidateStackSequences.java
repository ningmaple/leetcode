class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        if (pushed.length == 0) {
            return true;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int popPtr = 0;
        int pushPtr = 0;
        for (; pushPtr < pushed.length && popPtr < popped.length; pushPtr++) {
            while (!stack.isEmpty() && stack.peekFirst() == popped[popPtr]) {
                stack.pollFirst();
                popPtr++;
            }
            stack.offerFirst(pushed[pushPtr]);
        }

        while (!stack.isEmpty() && stack.peekFirst() == popped[popPtr]) {
            stack.pollFirst();
            popPtr++;
        }

        return stack.isEmpty() && popPtr == popped.length;
    }
}