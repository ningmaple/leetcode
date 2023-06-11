class Multiply_String {
public:
    string multiply(string num1, string num2) {
        if (num1.empty() && num2.empty()) {
            return "0";
        }
        if (num1.empty()) {
            return num2;
        }
        if (num2.empty()) {
            return num1;
        }
        if (num1 == "0" || num2 == "0") {
            return "0";
        }
        
        vector<string> nums;
        int max_len = 0;
        for (int i = num2.size() - 1; i >= 0; i--) {
            string product = multiply(num1, num2[i] - '0', num2.size() - 1 - i);
            nums.push_back(product);
            max_len = max(max_len, (int)product.size());
        }

        return add_nums(nums, max_len);
    }

private:
    string multiply(string& s, int num, int num_of_zero) {
        string product = "";
        int carry_over = 0;
        for (int i = s.size() - 1; i >= 0; i--) {
            carry_over += (s[i] - '0') * num;
            product.push_back('0' + carry_over % 10);
            carry_over /= 10;
        }
        if (carry_over != 0) {
            product.push_back('0' + carry_over);
        }

        reverse(product.begin(), product.end());
        for (int i = 0; i < num_of_zero; i++) {
            product.push_back('0');
        }
        reverse(product.begin(), product.end());
        return product;
    }

    string add_nums(vector<string>& nums, int max_len) {
        string sum = "";
        int carry_over = 0;
        for (int i = 0; i < max_len; i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i < nums[j].size()) {
                    carry_over += nums[j][i] - '0';
                }
            }
            sum.push_back(carry_over % 10 + '0');
            carry_over /= 10;
        }

        while (carry_over > 0) {
            sum.push_back(carry_over % 10 + '0');
            carry_over /= 10; 
        }
        reverse(sum.begin(), sum.end());
        return sum;
    }
};