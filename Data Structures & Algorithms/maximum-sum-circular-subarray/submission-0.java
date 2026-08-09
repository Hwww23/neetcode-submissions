class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int sum = nums[0];
        int globalMax = nums[0];
        int globalMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max + nums[i], nums[i]);
            min = Math.min(min + nums[i], nums[i]);

            globalMax = Math.max(globalMax, max);
            globalMin = Math.min(globalMin, min);
        }

        if (globalMax < 0) return globalMax;

        return Math.max(globalMax, sum - globalMin);
    }
}