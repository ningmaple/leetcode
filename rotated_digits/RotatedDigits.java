class RotatedDigits {
    public int rotatedDigits(int n) {
        if (n < 0) {
            return 0;
        }

        int counter = 0;
        for (int num = 1; num <= n; num++) {
            if (isValid(num)) {
                counter++;
            }
        }

        return counter;
    }

    private boolean isValid(int num) {
        boolean isValid = false;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                isValid = true;
            }
            num /= 10;
        }

        return isValid;
    }
}