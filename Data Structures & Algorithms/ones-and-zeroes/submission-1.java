class Solution {
    private int[][][] memo;
    private int[] zeros;
    private int[] ones;

    public int findMaxForm(String[] strs, int m, int n) {
        zeros = new int[strs.length];
        ones = new int[strs.length];
        memo = new int[strs.length][m + 1][n + 1];
        for (int[][] i : memo) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zeros[i]++;
                } else {
                    ones[i]++;
                }
            }
        }

        return dfs(0, 0, 0, m, n, strs);
    }

    private int dfs(int idx, int zero, int one, int m, int n, String[] strs) {
        if (idx == strs.length) {
            return 0;
        }

        if (memo[idx][zero][one] != -1) {
            return memo[idx][zero][one];
        }

        int skip = dfs(idx + 1, zero, one, m, n, strs);
        int take = 0;
        if (zero + zeros[idx] <= m && one + ones[idx] <= n) {
            take = 1 + dfs(idx + 1, zero + zeros[idx], one + ones[idx], m, n, strs);
        } 

        return memo[idx][zero][one] = Math.max(skip, take);
    }
}