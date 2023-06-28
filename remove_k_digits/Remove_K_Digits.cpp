class Remove_K_Digits {
public:
    string removeKdigits(string num, int k) {
        if (num.empty() || num.size() <= k) {
            return "0";
        }
        if (k < 1) {
            return num;
        }

        deque<int> stack;
        for (int i = 0; i < num.size(); i++) {
            while (!stack.empty() && stack.front() > num[i] - '0' && k-- > 0) {
                stack.pop_front();
            }
            stack.push_front(num[i] - '0');
        }

        string removed_num = "";
        while (!stack.empty() && (int)stack.size() > k) {
            if (removed_num.empty() && stack.back() == 0) {
                stack.pop_back();
                continue;
            }
            removed_num.push_back((char)(stack.back() + '0'));
            stack.pop_back();
        }
        return removed_num.size() == 0 ? "0" : removed_num;
    }
};