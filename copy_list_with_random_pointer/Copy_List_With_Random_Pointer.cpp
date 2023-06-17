/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Copy_List_With_Random_Pointer {
public:
    Node* copyRandomList(Node* head) {
        if (head == NULL) {
            return NULL;
        }
        
        unordered_map<Node*, Node*> nodes;
        return dfs(head, nodes);
    }
private: 
    Node* dfs(Node* node, unordered_map<Node*, Node*>& nodes) {
        if (node == NULL) {
            return NULL;
        }
        if (nodes.find(node) != nodes.end()) {
            return nodes[node];
        }

        nodes[node] = new Node(node->val);
        nodes[node]->next = dfs(node->next, nodes);
        nodes[node]->random = dfs(node->random, nodes);
        return nodes[node];
    }
};