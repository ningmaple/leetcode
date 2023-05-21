/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        return removeNthFromEnd(head, n, new int[]{0});
    }
    
    private ListNode removeNthFromEnd(ListNode head, int n, int[] counter) {
        if (head.next == null) {
            counter[0] = 1;
        } else {
            head.next = removeNthFromEnd(head.next, n, counter);  
            counter[0]++;
        }

        return counter[0] == n ? head.next : head;
    }
}