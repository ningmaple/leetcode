/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Add_Two_Numbers {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if (l1 == NULL && l2 == NULL) {
            return NULL;
        }
        if (l1 == NULL) {
            return l2;
        }
        if (l2 == NULL) {
            return l1;
        }
        
        ListNode* dummy = new ListNode(0);
        dfs(l1, l2, 0, dummy);
        return dummy->next;
    }

private:
    void dfs(ListNode* l1, ListNode* l2, int carry_over, ListNode* curr_node) {
        if (l1 == NULL && l2 == NULL && carry_over == 0) {
            return;
        }
        if (l1 == NULL && l2 == NULL) {
            curr_node->next = new ListNode(carry_over);
            return;
        }
        if (l1 == NULL) {
            carry_over += l2->val;
            curr_node->next = new ListNode(carry_over % 10);
            dfs(l1, l2->next, carry_over / 10, curr_node->next);
            return;
        }
        if (l2 == NULL) {
            carry_over += l1->val;
            curr_node->next = new ListNode(carry_over % 10);
            dfs(l1->next, l2, carry_over / 10, curr_node->next);
            return;
        }
        
        carry_over += l1->val + l2->val;
        curr_node->next = new ListNode(carry_over % 10);
        dfs(l1->next, l2->next, carry_over / 10, curr_node->next);        
    }
};