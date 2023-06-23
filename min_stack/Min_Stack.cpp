class Min_Stack {
private:
    stack<int*>* min_stack;
    
public:
    MinStack() {
        this->min_stack = new stack<int*>();
    }
    
    void push(int val) {
        int curr_min = (*min_stack).empty() ? val : min((*min_stack).top()[1], val);
        (*min_stack).push(new int[]{val, curr_min});
    }
    
    // c++中pop后自动调用指针的析构函数。返回类型是void。这点和java不同。
    void pop() {
        if ((*min_stack).empty()) {
            return;
        }
        (*min_stack).pop();
    }
    
    int top() {
        if ((*min_stack).empty()) {
            return INT_MIN;
        }
        return (*min_stack).top()[0];
    }
    
    int getMin() {
        if ((*min_stack).empty()) {
            return INT_MIN;
        }
        return (*min_stack).top()[1]; 
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */