class Rotated_Digits {
public:
    int rotatedDigits(int n) {
        if (n < 0) {
            return 0;
        }

        int counter = 0;
        for (int num = 1; num <= n; num++) {
            if (is_valid(num)) {
                counter++;
            }
        }

        return counter;
    }

private:
    bool is_valid(int num) {
        bool is_valid = false;
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                is_valid = true;
            }
        }

        return is_valid;
    }
};