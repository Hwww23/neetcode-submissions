class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            int tempMax = Math.max(n * max, Math.max(n * min, n));
            int tempMin = Math.min(n * max, Math.min(n * min, n));

            max = tempMax;
            min = tempMin;

            res = Math.max(max, res);
        }

        return res;
    }
}
