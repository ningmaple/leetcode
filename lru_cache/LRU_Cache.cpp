class Node {
private: 
    int key;
    int val;
    Node* prev;
    Node* next;
public:
    Node(int key, int value) {
        this->key = key;
        this->val = value;
        this->prev = this;
        this->next = this;
    }
    ~Node(){};
    friend class LRUCache;
};

class LRUCache {
private:
    unordered_map<int, Node*> nodes;
    int cap;
    Node* head;
    Node* tail;
    
public:
    LRUCache(int capacity) {
        this->cap = capacity;
        this->head = new Node(INT_MIN, INT_MIN);
        this->tail = new Node(INT_MAX, INT_MAX);
        this->head->next = this->tail;
        this->tail->prev = this->head;
    }
    
    int get(int key) {
        if (nodes.find(key) == nodes.end()) {
            return -1;
        }
        
        Node* node = nodes[key];
        remove(node);
        insert(node);
        return node->val;
    }
    
    void put(int key, int value) {
        if (nodes.find(key) != nodes.end()) {
            Node* node = nodes[key];
            node->val = value;
            remove(node);
            insert(node);
            return;
        }
        
        Node* new_node = new Node(key, value);
        nodes[key] = new_node;
        insert(new_node);
        if (nodes.size() > this->cap) {
            Node* node = this->tail->prev;
            remove(node);
            nodes.erase(node->key);
            delete node;
        }
    }
    
private:
    void remove(Node* node) {
        node->prev->next = node->next;
        node->next->prev = node->prev;
        node->prev = node;
        node->next = node;
    }
    
    void insert(Node* node) {
        node->next = this->head->next;
        node->prev = this->head;
        this->head->next->prev = node;
        this->head->next = node;
    }
};