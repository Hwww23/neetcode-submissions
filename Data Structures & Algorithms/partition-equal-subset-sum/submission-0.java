class Solution {
    Boolean[] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 != 0) return false;

        int half = sum / 2;
        memo = new Boolean[half + 1];

        return dfs(0, nums, half);
    }

    private boolean dfs(int idx, int[] nums, int remainder) {
        if (remainder == 0) {
            return true;
        }

        if (remainder < 0) {
            return false;
        }

        if (memo[remainder] != null) {
            return memo[remainder];
        }

        for (int i = idx; i < nums.length; i++) {
            if (dfs(i + 1, nums, remainder - nums[i])) {
                return memo[remainder] = true;
            }
        }

        return memo[remainder] = false;
    }
}
