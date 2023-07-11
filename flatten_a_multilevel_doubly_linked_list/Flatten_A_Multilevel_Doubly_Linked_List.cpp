/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};
*/

class Flatten_A_Multilevel_Doubly_Linked_List {
public:
    Node* flatten(Node* head) {
        if (head == NULL) {
            return head;
        }
        if (head->child == NULL) {
            flatten(head->next);
            return head;
        }

        Node* child = head->child;
        Node* next = head->next;
        head->child = NULL;
        head->next = NULL;
        if (next != NULL) {
            next->prev = NULL;
        }

        head->next = flatten(child);
        head->next->prev = head;

        Node* curr = head;
        while (curr != NULL && curr->next != NULL) {
            curr = curr->next;
        }
        curr->next = next;
        if (next != NULL) {
            next->prev = curr;
        }

        return head;
    }
};