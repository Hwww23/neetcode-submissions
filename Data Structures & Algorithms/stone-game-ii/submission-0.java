class Solution {
    int[][] memo;
    int[] prefixSum;

    public int stoneGameII(int[] piles) {
        memo = new int[piles.length][piles.length / 2];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        
        prefixSum = new int[piles.length + 1];
        for (int i = 0; i < piles.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + piles[i];
        }

        return dfs(0, 1, piles);
    }

    private int dfs(int i, int m, int[] piles) {
        if (2 * m >= piles.length - i) {
            return prefixSum[piles.length] - prefixSum[i];
        }

        if (memo[i][m] != -1) {
            return memo[i][m];
        }

        int rem = prefixSum[piles.length] - prefixSum[i];
        int min = Integer.MAX_VALUE;
        
        for (int j = 1; j <= 2 * m; j++) {
            min = Math.min(min, dfs(i + j, Math.max(m, j), piles));
        }

        return memo[i][m] = rem - min;
    }
}