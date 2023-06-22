class LRUCache {
    private static class Node {
        private Node prev;
        private Node next;
        private final int key;
        private int val;
        public Node(int key, int val) {
            this.prev = this;
            this.next = this;
            this.key = key;
            this.val = val;
        }
    }
    private final Map<Integer, Node> nodes;
    private final int cap;
    private final Node head;
    private final Node tail;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.nodes = new HashMap<>();
        this.head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        this.tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (!this.nodes.containsKey(key)) {
            return -1;
        }
        
        Node node = nodes.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            node.val = value;
            remove(node);
            insert(node);
            return;
        }
        
        Node newNode = new Node(key, value);
        nodes.put(key, newNode);
        insert(newNode);
        if (nodes.size() > this.cap) {
            Node node = this.tail.prev;
            remove(node);
            nodes.remove(node.key);
        }
    }
    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = node;
        node.next = node;
    }
    
    private void insert(Node node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next = node;
        node.next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */