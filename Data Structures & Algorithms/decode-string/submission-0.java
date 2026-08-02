class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int curr = 0;
        StringBuilder currString = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(curr);
                stringStack.push(currString);
                curr = 0;
                currString = new StringBuilder();
            } else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    prev.append(currString);
                }
                currString = prev;
            } else {
                currString.append(c);
            }
        }

        return currString.toString();
    }
}