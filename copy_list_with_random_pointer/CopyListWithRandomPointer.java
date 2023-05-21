/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        return copyRandomList(head, new HashMap<>());
    }
    
    private Node copyRandomList(Node head, Map<Node, Node> nodes) {
        if (head == null) {
            return null;
        }
        if (nodes.containsKey(head)) {
            return nodes.get(head);
        }
        if (!nodes.containsKey(head)) {
            nodes.put(head, new Node(head.val));
        }
        
        Node newHead = nodes.get(head);
        newHead.next = copyRandomList(head.next, nodes);
        newHead.random = copyRandomList(head.random, nodes);
        return newHead;
    }
}