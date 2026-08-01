class Solution {
    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = Math.max(memo[i], Math.max(i - j, memo[i - j]) * j);
            }
        }

        return memo[n];
    }
}