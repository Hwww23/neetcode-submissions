class Solution {
    int[] memo;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(robRange(0, nums.length - 2, nums), robRange(1, nums.length - 1, nums));
    }

    private int robRange(int l, int r, int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(l, r, nums);
    }

    private int dfs(int i, int end, int[] nums) {
        if (i > end) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        return memo[i] = Math.max(dfs(i + 1, end, nums), nums[i] + dfs(i + 2, end, nums));
    }
}
