class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int curr = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                curr = curr * 10 + (s.charAt(i) - '0');
            }

            if (!Character.isDigit(s.charAt(i)) || i == s.length() - 1) {
                if (op == '+') {
                    stack.push(curr);
                } else if (op == '-') {
                    stack.push(-curr);
                } else if (op == '*') {
                    int val = stack.pop() * curr;
                    stack.push(val);
                } else if (op == '/') {
                    int val = stack.pop() / curr;
                    stack.push(val);
                }

                curr = 0;
                op = s.charAt(i);
            }
        }   

        int res = 0;

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}