class Solution {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length() + 1][word2.length() + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs(0, 0, word1, word2);
    }

    private int dfs(int i, int j, String word1, String word2) {
        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = dfs(i + 1, j + 1, word1, word2);
        }

        int insert = dfs(i, j + 1, word1, word2);
        int replace = dfs(i + 1, j + 1, word1, word2);
        int delete = dfs(i + 1, j, word1, word2);

        return memo[i][j] = 1 + Math.min(insert, Math.min(replace, delete));
    }
}
