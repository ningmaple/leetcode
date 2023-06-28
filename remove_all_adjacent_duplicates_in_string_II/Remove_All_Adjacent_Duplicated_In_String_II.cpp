class Remove_All_Adjacent_Duplicated_In_String_II {
public:
    // tc: O(n); sc: O(n)
    string removeDuplicates(string s, int k) {
        if (s.empty() || k == 1) {
            return "";
        }
        if (s.size() < 2 || k < 1) {
            return s;
        }

        deque<char> ch_stack;
        deque<int> counter_stack;
        for (int i = 0; i < s.size(); i++) {
            if (ch_stack.empty() || ch_stack.front() != s[i]) {
                ch_stack.push_front(s[i]);
                counter_stack.push_front(1);
                continue;
            }
            if (++counter_stack.front() == k) {
                ch_stack.pop_front();
                counter_stack.pop_front();
            }
        }
        
        string removed_duplicates_str = "";
        while (!ch_stack.empty()) {
            char ch = ch_stack.back();
            ch_stack.pop_back();
            int counter = counter_stack.back();
            counter_stack.pop_back();
            for (int i = 0; i < counter; i++) {
                removed_duplicates_str.push_back(ch);
            }
        }
        return removed_duplicates_str;
    }

    // tc: O(nk); sc: O(1)
    string removeDuplicates(string s, int k) {
        if (s.empty() || k == 1) {
            return "";
        }
        if (s.size() < 2 || k < 1) {
            return s;
        }

        int len = 0;
        for (int fast = 0; fast < s.size(); fast++) {
            s[len] = s[fast];
            int slow = len;
            while (slow - 1 >= 0 && s[slow - 1] == s[len]) {
                slow--;
            }
            if (len - slow + 1 >= k) {
                len = slow;
            } else {
                len++;
            }
        }

        return s.substr(0, len);
    }
};