class Solution {
    int[][] memo;

    public int maxCoins(int[] nums) {
        int[] nums1 = new int[nums.length + 2];
        nums1[0] = 1;
        nums1[nums1.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            nums1[i + 1] = nums[i];
        }

        memo = new int[nums.length + 2][nums.length + 2];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs(0, nums.length + 1, nums1);
    }

    private int dfs(int l , int r, int[] nums) {
        if (l + 1 == r) {
            return 0;
        }

        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        int max = 0;
        for (int i = l + 1; i < r; i++) {
            max = Math.max(max, dfs(l, i, nums) + nums[l] * nums[i] * nums[r] + dfs(i, r, nums));
        }

        return memo[l][r] = max;
    }
}
