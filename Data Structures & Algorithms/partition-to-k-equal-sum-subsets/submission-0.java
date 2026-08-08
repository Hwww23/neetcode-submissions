class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum % k != 0) return false;

        int target = sum / k;
        int[] sides = new int[k];

        return dfs(0, nums, sides, target);
    }

    private boolean dfs(int i, int[] nums, int[] sides, int target) {
        if (i == nums.length) {
            return true;
        }

        for (int j = 0; j < sides.length; j++) {
            if (sides[j] + nums[i] <= target) {
                sides[j] += nums[i];

                if (dfs(i + 1, nums, sides, target)) {
                    return true;
                }
                sides[j] -= nums[i];
            }

            if (sides[j] == 0) break;
        }

        return false;
    }
}