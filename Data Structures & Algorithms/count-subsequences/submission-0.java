class Solution {
    int[][] memo;

    public int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for(int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs(0, 0, s, t);
    }

    private int dfs(int i, int j, String s, String t) {
        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        memo[i][j] = dfs(i + 1, j, s, t);
        if (s.charAt(i) == t.charAt(j)) {
            memo[i][j] += dfs(i + 1, j + 1, s, t);
        }

        return memo[i][j];
    }
}
