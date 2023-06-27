class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        if (s == null || s.length() == 0 || queries == null || queries.length == 0) {
            return new int[0];
        }

        TreeMap<Integer, Integer> prefixSum = new TreeMap<>();
        boolean start = false;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*' && start) {
                counter++;
                continue;
            }
            if (ch == '|') {
                prefixSum.put(i, counter);
                start = true;
            }
        }

        int[] platesArray = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            Map.Entry<Integer, Integer> left = prefixSum.ceilingEntry(query[0]);
            Map.Entry<Integer, Integer> right = prefixSum.floorEntry(query[1]);
            if (left != null && right != null && left.getKey() <= right.getKey()) {
                platesArray[i] = right.getValue() - left.getValue();
            }
        } 
        
        return platesArray;
    }
}