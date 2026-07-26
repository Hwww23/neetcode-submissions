class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0;
        int neg = 0;

        int idx = 0;

        while (idx < nums.length) {
            while (nums[pos] < 0) {
                pos++;
            }
            res[idx++] = nums[pos++];

            // if (idx == nums.length) break;

            while (nums[neg] > 0) {
                neg++;
            }
            res[idx++] = nums[neg++];
        }

        return res;
    }
}