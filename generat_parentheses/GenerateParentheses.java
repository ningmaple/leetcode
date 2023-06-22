class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<String>();
        }

        List<String> parenthesises = new ArrayList<>();
        dfs(n, 0, 0, 0, new StringBuilder(), parenthesises);
        return parenthesises;
    }
    
    private void dfs(int n, int pairs, int leftCounter, int rightCounter, StringBuilder sb, List<String> parenthesises) {
        if (pairs == n) {
            parenthesises.add(sb.toString());
            return;
        }
        
        if (leftCounter < n) {
            sb.append('(');
            dfs(n, pairs, leftCounter + 1, rightCounter, sb, parenthesises);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (rightCounter < leftCounter) {
            sb.append(')');
            dfs(n, pairs + 1, leftCounter, rightCounter + 1, sb, parenthesises);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
