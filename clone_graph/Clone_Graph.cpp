/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Clone_Graph {
public:
    Node* cloneGraph(Node* node) {
        if (node == NULL) {
            return node;
        }
        unordered_map<Node*, Node*> nodes;
        return dfs(node, nodes);
    }
    
private:
    Node* dfs(Node* node, unordered_map<Node*, Node*>& nodes) {
        if (nodes.find(node) != nodes.end()) {
            return nodes[node];
        }
        if (nodes.find(node) == nodes.end()) {
            Node* clone_node = new Node(node->val);
            nodes[node] = clone_node;
        }
        
        for (auto& nei : node->neighbors) {
            nodes[node]->neighbors.push_back(dfs(nei, nodes));
        }
        return nodes[node];
    }
};