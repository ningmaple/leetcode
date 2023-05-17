public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        
        int carryOver = 1;        
        for (int i = digits.length - 1; i >= 0; i--) {
            carryOver += digits[i];
            digits[i] = carryOver % 10;
            carryOver /= 10;
            if (carryOver == 0) {
                return digits;
            }
        }
        
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = carryOver;
        for (int i = 1; i < newDigits.length; i++) {
            newDigits[i] = digits[i - 1];
        }
        return newDigits;
    }
}