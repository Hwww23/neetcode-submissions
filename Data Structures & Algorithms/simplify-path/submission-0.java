class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : arr) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        if (stack.isEmpty()) return "/";

        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        return res;
    }
}