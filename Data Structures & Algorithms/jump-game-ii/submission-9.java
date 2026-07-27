class Solution {
    public int jump(int[] nums) {
        int curr = 0;
        int max = 0;
        int steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);

            if (i == curr) {
                steps++;
                curr = max;
            }
        }

        return steps;
    }
}
