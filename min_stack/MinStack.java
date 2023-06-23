class MinStack {
    private Deque<int[]> stack;
    
    public MinStack() {
        this.stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int min = this.stack.isEmpty() ? val : Math.min(val, this.stack.peekFirst()[1]);
        this.stack.offerFirst(new int[]{val, min});
    }
    
    public void pop() {
        if (this.stack.isEmpty()) {
            return;
        }
        this.stack.pollFirst();
    }
    
    public int top() {
        if (this.stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return this.stack.peekFirst()[0];
    }
    
    public int getMin() {
        if (this.stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return this.stack.peekFirst()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */