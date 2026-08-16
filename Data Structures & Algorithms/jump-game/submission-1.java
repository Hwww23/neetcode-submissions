class Solution {
    public boolean canJump(int[] nums) {
        int currEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > currEnd) return false;

            currEnd = Math.max(currEnd, i + nums[i]);

            if (currEnd >= nums.length - 1) return true;
        }

        return true;
    }
}
