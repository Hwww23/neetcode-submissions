class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0;
        int neg = 1;

        for (int n : nums) {
            if (n > 0) {
                res[pos] = n;
                pos += 2;
            } else {
                res[neg] = n;
                neg += 2;
            }
        }

        return res;
    }
}