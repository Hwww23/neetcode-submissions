class Solution {
    public int trap(int[] height) {
        int l = 1;
        int r = height.length - 2;
        int left = height[0];
        int right = height[height.length -1];
        int total = 0;

        while (l <= r) {
            if (left <= right) {
                total += Math.max(0, left - height[l]);
                left = Math.max(left, height[l]);
                l++;
            } else {
                total += Math.max(0, right - height[r]);
                right = Math.max(right, height[r]);
                r--;
            }
        }

        return total;
    }
}
