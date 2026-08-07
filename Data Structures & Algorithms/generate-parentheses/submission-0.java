class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(0, n, n, new StringBuilder(), n);
        return res;
    }

    private void dfs(int sum, int open, int close, StringBuilder path, int n) {
        if (sum < 0) return;
        
        if (path.length() == n * 2) {
            res.add(path.toString());
            return;
        }

        if (open > 0) {
            path.append('(');
            dfs(sum + 1, open - 1, close, path, n);
            path.deleteCharAt(path.length() - 1);
        }
        
        if (close > 0) {
            path.append(')');
            dfs(sum - 1, open, close - 1, path, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
