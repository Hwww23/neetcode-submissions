class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                    max = Math.max(max, memo[i]);
                }
            }
        }

        return max;
    }
}
