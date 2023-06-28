class Validate_Stack_Sequences {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        if (pushed.empty() && popped.empty()) {
            return true;
        }
        if (pushed.size() != popped.size()) {
            return false;
        }

        int push_ptr = 0;
        int popped_ptr = 0;
        stack<int> my_stack;
        for (; push_ptr < pushed.size() && popped_ptr < popped.size(); push_ptr++) {
            while (!my_stack.empty() && my_stack.top() == popped[popped_ptr]) {
                my_stack.pop();
                popped_ptr++;
            }
            my_stack.push(pushed[push_ptr]);
        }

        while (!my_stack.empty() && my_stack.top() == popped[popped_ptr]) {
            my_stack.pop();
            popped_ptr++;
        }

        return my_stack.empty() && popped_ptr == popped.size();
    }
};