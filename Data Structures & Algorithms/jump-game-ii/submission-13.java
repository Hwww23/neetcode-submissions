class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int currEnd = 0;
        int nextEnd = 0;
        int steps = 0;

        for (int i = 0; i < nums.length; i++) {
            nextEnd = Math.max(nextEnd, i + nums[i]);

            if (nextEnd >= nums.length - 1) {
                return steps + 1;
            }

            if (i == currEnd) {
                steps++;
                currEnd = nextEnd;
            }
        }

        return steps;
    }
}
