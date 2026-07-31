class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int diff = stack.peek() + ast;
                if (diff > 0) {
                    ast = 0;
                } else if (diff == 0) {
                    stack.pop();
                    ast = 0;
                } else {
                    stack.pop();
                }
            }

            if (ast != 0) stack.push(ast);
        }

        int[] res = new int[stack.size()];
        int i = 0;
        for (int s : stack) {
            res[i++] = s;
        }

        return res;
    }
}