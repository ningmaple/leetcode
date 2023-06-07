class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows < 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < numRows; line++) {
            for (int group = 0; line + group * (2 * numRows - 2) < s.length(); group++) {
                sb.append(s.charAt(line + group * (2 * numRows - 2)));
                if (line == 0 || line == numRows - 1 || (group + 1) * (2 * numRows - 2) - line >= s.length()) {
                    continue;
                }
                sb.append(s.charAt((group + 1) * (2 * numRows - 2) - line));
            }
        }

        return sb.toString();
    }
}