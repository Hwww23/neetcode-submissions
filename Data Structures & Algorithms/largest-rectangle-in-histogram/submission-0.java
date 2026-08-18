class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int l = i;
            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int[] node = stack.pop();
                int start = node[0];
                int height = node[1];

                max = Math.max(max, (i - start) * height);

                l = start;
            }

            stack.push(new int[] {l, heights[i]});
        }

        for (int[] s : stack) {
            max = Math.max(max, (heights.length - s[0]) * s[1]);
        }

        return max;
    }
}
