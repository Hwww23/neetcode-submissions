class Solution {
    Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        if (s1.equals("")) return s2.equals(s3);
        if (s2.equals("")) return s1.equals(s3);

        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0, 0, s1, s2, s3);
    }

    private boolean dfs(int i, int j, String s1, String s2, String s3) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(i + j));
        }

        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(i + j));
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s3.charAt(i + j) && dfs(i + 1, j, s1, s2, s3)) {
            return memo[i][j] = true;
        }

        if (s2.charAt(j) == s3.charAt(i + j) && dfs(i, j + 1, s1, s2, s3)) {
            return memo[i][j] = true;
        }

        return memo[i][j] = false;
    }
}
