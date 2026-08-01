class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 != 0) return false;

        int half = sum / 2;
        boolean[] memo = new boolean[half + 1];
        memo[0] = true;

        for (int num : nums) {
            for (int j = half; j >= num; j--) {
                memo[j] |= memo[j - num];
            }
        }

        return memo[half];
    }
}
