class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        long[] prefixSum = new long[nums.length + 1];

        long curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            prefixSum[i + 1] = curr;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long cur = prefixSum[j + 1] - prefixSum[i];
                if ((cur % k == 0 || cur == 0) && j - i + 1 >= 2) {
                    return true;
                }
            }
        }

        return false;
    }
}