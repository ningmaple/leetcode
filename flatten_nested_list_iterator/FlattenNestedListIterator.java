/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new ArrayDeque<>(nestedList);
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return this.stack.pollFirst().getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!this.stack.isEmpty() && !this.stack.peekFirst().isInteger()) {
            List<NestedInteger> topElementList = this.stack.pollFirst().getList();
            for (int i = topElementList.size() - 1; i >= 0; i--) {
                this.stack.offerFirst(topElementList.get(i));
            }
        }
        return !this.stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
 