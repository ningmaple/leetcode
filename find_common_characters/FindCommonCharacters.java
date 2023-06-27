class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        if (words == null || words.length < 2) {
            return new ArrayList<String>();
        }

        Map<Character, int[]> commonsCounter = new HashMap<>();
        for (int i = 0; i < words[0].length(); i++) {
            char ch = words[0].charAt(i);
            if (!commonsCounter.containsKey(ch)) {
                commonsCounter.put(ch, new int[]{0});
            }
            commonsCounter.get(ch)[0]++;
        }

        for (int i = 1; i < words.length; i++) {
            Map<Character, int[]> currCounter = new HashMap<>();
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                if (!currCounter.containsKey(ch)) {
                    currCounter.put(ch, new int[]{0});
                }
                currCounter.get(ch)[0]++;
            }

            for (Map.Entry<Character, int[]> counter : commonsCounter.entrySet()) {
                char ch = counter.getKey();
                if (!currCounter.containsKey(ch)) {
                    commonsCounter.get(ch)[0] = 0;
                    continue;
                }
                commonsCounter.get(ch)[0] = Math.min(counter.getValue()[0], currCounter.get(ch)[0]);
            }
        }

        List<String> commonChars = new ArrayList<>();
        for (Map.Entry<Character, int[]> counter : commonsCounter.entrySet()) {
            for (int i = 0; i < counter.getValue()[0]; i++) {
                commonChars.add(String.valueOf(counter.getKey()));
            }
        }
        return commonChars;
    }
}