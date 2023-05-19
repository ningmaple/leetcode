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
 
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val == o2.val) {
                    return 0;
                }
                return o1.val < o2.val ? -1 : 1;
            }
        });
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);   
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode currNode = dummy;
        while (!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();
            currNode.next = curr;
            currNode = currNode.next;
            if (curr.next != null) {
                minHeap.offer(curr.next);
            }
        }
        
        return dummy.next;
    }
}