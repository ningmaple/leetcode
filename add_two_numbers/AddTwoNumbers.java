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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    
    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carryOver) {
        if (l1 == null && l2 == null && carryOver == 0) {
            return null;
        }
        if (l1 == null && l2 == null) {
            return new ListNode(carryOver);
        }
        if (l1 == null) {
            carryOver += l2.val;
            l2.val = carryOver % 10;
            carryOver /= 10;
            l2.next = addTwoNumbers(l1, l2.next, carryOver);
            return l2;
        }
        if (l2 == null) {
            carryOver += l1.val;
            l1.val = carryOver % 10;
            carryOver /= 10;
            l1.next = addTwoNumbers(l1.next, l2, carryOver);
            return l1;
        }
        
        carryOver += l1.val + l2.val;
        l1.val = carryOver % 10;
        carryOver /= 10;
        l1.next = addTwoNumbers(l1.next, l2.next, carryOver);
        return l1;
    }
}
