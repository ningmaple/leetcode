class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        if (queries == null || queries.length == 0) {
            return new ArrayList<Boolean>();
        }

        List<Boolean> camelMatches = new ArrayList<>();
        if (pattern == null || pattern.length() == 0) {
            Collections.fill(camelMatches, false);
            return camelMatches;
        }

        for (String query : queries) {
            camelMatches.add(camelMatch(query, pattern));
        }

        return camelMatches;
    }

    private boolean camelMatch(String query, String pattern) {
        int qPtr = 0;
        int pPtr = 0;
        while (qPtr < query.length() && pPtr < pattern.length()) {
            char q = query.charAt(qPtr++);
            char p = pattern.charAt(pPtr);
            if (p == q) {
                pPtr++;
                continue;
            }
            if (Character.isUpperCase(q)) {
                return false;
            }
        }
        while (qPtr < query.length() && Character.isLowerCase(query.charAt(qPtr))) {
            qPtr++;
        }

        return qPtr == query.length() && pPtr == pattern.length();
    }
}