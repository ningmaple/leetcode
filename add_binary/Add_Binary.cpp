class Add_Binary {
public:
    string addBinary(string a, string b) {
        if (a.empty() && b.empty()) {
            return "0";
        }
        if (a.empty() || a == "0") {
            return b;
        }
        if (b.empty() || b == "0") {
            return a;
        }
        
        int ptr_a = a.size() - 1;
        int ptr_b = b.size() - 1;
        int carry_over = 0;
        string sum = "";
        while (ptr_a >= 0 && ptr_b >= 0) {
            carry_over += (a[ptr_a--] - '0') + (b[ptr_b--] - '0');
            sum.push_back((carry_over & 1) + '0');
            carry_over >>= 1;
        }
        while (ptr_a >= 0) {
            carry_over += (a[ptr_a--] - '0');
            sum.push_back((carry_over & 1) + '0');
            carry_over >>= 1;
        }
        while (ptr_b >= 0) {
            carry_over += (b[ptr_b--] - '0');
            sum.push_back((carry_over & 1) + '0');
            carry_over >>= 1;
        }
        
        if (carry_over == 1) {
            sum.push_back('1');
        }
        reverse(sum.begin(), sum.end());
        return sum;
    }
};