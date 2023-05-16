public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return "";
        }
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        String[] nums = new String[num1.length()];
        for (int i = 0; i < num1.length(); i++) {
            nums[i] = helper(num2, num1.charAt(i) - '0', num1.length() - 1 - i);
        }
        
        return addNums(nums);
    }
    
    private String helper(String s, int num, int zeros) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeros; i++) {
            sb.append('0');
        }
        int carryOver = 0;
        for (int ptr = s.length() - 1; ptr >= 0; ptr--) {
            int curr = carryOver + (s.charAt(ptr) - '0') * num;
            sb.append(curr % 10);
            carryOver = curr / 10;
        }
        while (carryOver > 0) {
            sb.append(carryOver % 10);
            carryOver /= 10;
        }
        
        return sb.reverse().toString();
    }
    
    private String addNums(String[] nums) {
        int[] ptrs = new int[nums.length];
        int longest = 0;
        for (int i = 0; i < ptrs.length; i++) {
            ptrs[i] = nums[i].length() - 1;
            longest = Math.max(longest, ptrs[i]);
        }

        StringBuilder sb = new StringBuilder();
        int carryOver = 0;
        while (longest-- >= 0) {
            int currAns = carryOver;
            for (int i = 0; i < ptrs.length; i++) {
                currAns += ptrs[i] >= 0 ? (nums[i].charAt(ptrs[i]--) - '0') : 0;
            }
            
            carryOver = currAns / 10;
            sb.append(currAns % 10);
        }

        while (carryOver > 0) {
            sb.append(carryOver % 10);
            carryOver /= 10;
        }
        return sb.reverse().toString();
    }
}