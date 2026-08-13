class Solution {
    Integer[][] memo;
    int sum = 0;

    public int findTargetSumWays(int[] nums, int target) {
        for (int n : nums) {
            sum += n;
        }

        memo = new Integer[nums.length][sum * 2 + 1];
        return dfs(0, 0, nums, target);
    }

    private int dfs(int i, int currSum, int[] nums, int target) {
        if (i == nums.length && currSum == target) {
            return 1;
        }

        if (i == nums.length) {
            return 0;
        }

        if (memo[i][currSum + sum] != null) {
            return memo[i][currSum + sum];
        }

        return memo[i][currSum + sum] = dfs(i + 1, currSum + nums[i], nums, target) 
                                        + dfs(i + 1, currSum - nums[i], nums, target);
    }
}
