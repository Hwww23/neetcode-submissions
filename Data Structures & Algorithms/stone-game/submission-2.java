class Solution {
    int[][] memo;

    public boolean stoneGame(int[] piles) {
        memo = new int[piles.length][piles.length];
        for (int[] m : memo) {
            Arrays.fill(m, Integer.MIN_VALUE);
        }

        return dfs(0, piles.length - 1, piles) > 0;
    }

    private int dfs(int i, int j, int[] piles) {
        if (i == j) {
            return piles[i];
        }

        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        return memo[i][j] = Math.max(piles[i] - dfs(i + 1, j, piles), piles[j] - dfs(i, j - 1, piles));
    }
}