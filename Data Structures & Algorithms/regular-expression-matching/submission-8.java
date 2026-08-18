class Solution {
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[p.length() + 1][s.length() + 1];
        return dfs(0, 0, p, s);
    }

    private boolean dfs(int i, int j, String p, String s) {
        if (i == p.length()) {
            return j == s.length();
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean match = j < s.length() && (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.');

        if (i < p.length() - 1 && p.charAt(i + 1) == '*') {
            memo[i][j] = dfs(i + 2, j, p, s) || (match && dfs(i, j + 1, p, s));
        } else {
            memo[i][j] = match && dfs(i + 1, j + 1, p, s);
        }

        return memo[i][j];
    }
}