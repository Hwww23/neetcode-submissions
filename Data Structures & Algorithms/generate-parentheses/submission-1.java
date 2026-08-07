class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, n, new StringBuilder(), n);
        return res;
    }

    private void dfs(int open, int close, StringBuilder path, int n) {
        if (open == 0 && close == 0) {
            res.add(path.toString());
            return;
        }

        if (open > 0) {
            path.append('(');
            dfs(open - 1, close, path, n);
            path.deleteCharAt(path.length() - 1);
        }
        
        if (close > open) {
            path.append(')');
            dfs(open, close - 1, path, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
