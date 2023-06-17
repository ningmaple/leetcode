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
class Reorder_List {
public:
    void reorderList(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return;
        }
        
        ListNode* mid = find_mid(head);
        merge_nodes(head, reverse_nodes(mid), 0);
    }

private: 
    ListNode* find_mid(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* prev = NULL;
        while (fast != NULL && fast->next != NULL) {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        prev->next = NULL;
        return slow;
    }
    
    ListNode* reverse_nodes(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        
        ListNode* new_head = reverse_nodes(head->next);
        head->next->next = head;
        head->next = NULL;
        return new_head;
    }
    
    ListNode* merge_nodes(ListNode* l1, ListNode* l2, int ctrl) {
        if (l1 == NULL && l2 == NULL) {
            return NULL;
        }
        if (l1 == NULL) {
            return l2;
        }
        if (l2 == NULL) {
            return l1;
        }
        if (ctrl == 0) {
            l1->next = merge_nodes(l1->next, l2, 1 - ctrl);
            return l1;
        }
        l2->next = merge_nodes(l1, l2->next, 1 - ctrl);
        return l2;
    }
};