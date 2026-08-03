class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxA = 0;

        while (l < r) {
            int maxHeight = Math.min(heights[l], heights[r]);
            maxA = Math.max(maxA, maxHeight * (r - l));

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxA;
    }
}
