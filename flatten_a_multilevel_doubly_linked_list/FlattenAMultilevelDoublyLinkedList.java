/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        if (head.child == null) {
            flatten(head.next);
            return head;
        }

        Node childNode = head.child;
        Node nextNode = head.next;
        head.child = null;
        if (nextNode != null) {
            nextNode.prev = null;
        }

        head.next = flatten(childNode);
        head.next.prev = head;

        Node curr = head;
        while (curr != null && curr.next != null) {
            curr = curr.next;
        }
        curr.next = nextNode;
        if (nextNode != null) {
            curr.next.prev = curr;
        }

        return head;
    }
}