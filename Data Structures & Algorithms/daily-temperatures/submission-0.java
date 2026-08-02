class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] node = stack.pop();
                res[node[0]] = i - node[0];
            }
            stack.push(new int[] {i, temperatures[i]});
        }

        return res;
    }
}
