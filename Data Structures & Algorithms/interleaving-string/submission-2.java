class Solution {
    private Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        if (s1.equals("")) return s2.equals(s3);
        if (s2.equals("")) return s1.equals(s3);
        
        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0, 0, 0, s1, s2, s3);
    }

    private boolean dfs(int idx, int i, int j, String s1, String s2, String s3) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (i < s1.length() && s1.charAt(i) == s3.charAt(idx)) {
            memo[i][j] = dfs(idx + 1, i + 1, j, s1, s2, s3);
        }

        if (memo[i][j] != null && memo[i][j]) return memo[i][j];

        if (j < s2.length() && s2.charAt(j) == s3.charAt(idx)) {
            memo[i][j] = dfs(idx + 1, i, j + 1, s1, s2, s3);
        }

        if (memo[i][j] != null && memo[i][j]) return memo[i][j];

        return memo[i][j] = false;
    }
}
