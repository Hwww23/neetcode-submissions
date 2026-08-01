class Solution {
    public int numSquares(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            nums.add(i);
        }

        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int num : nums) {
                if (i - num * num >= 0) {
                    memo[i] = Math.min(memo[i], 1 + memo[i - num * num]);
                }
            }
        }

        return memo[n];
    }
}