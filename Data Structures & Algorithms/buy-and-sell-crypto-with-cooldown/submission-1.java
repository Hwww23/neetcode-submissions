class Solution {
    int[][] memo;

    public int maxProfit(int[] prices) {
        memo = new int[prices.length][2];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs(0, 1, prices);
    }

    private int dfs(int i, int canBuy, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }

        if (memo[i][canBuy] != -1) {
            return memo[i][canBuy];
        }

        int skip = dfs(i + 1, canBuy, prices);
        if (canBuy == 1) {
            int buy = -prices[i] + dfs(i + 1, 0, prices);
            memo[i][canBuy] = Math.max(skip, buy);
        } else {
            int sell = prices[i] + dfs(i + 2, 1, prices);
            memo[i][canBuy] = Math.max(skip, sell);
        }

        return memo[i][canBuy];
    }
}
