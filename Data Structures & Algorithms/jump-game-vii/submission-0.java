class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] memo = new boolean[s.length()];
        memo[0] = true;
        int reachable = 0;

        for (int i = minJump; i < s.length(); i++) {
            if (memo[i - minJump]) {
                reachable++;
            }

            if (i - maxJump - 1 >= 0 && memo[i - maxJump - 1]) {
                reachable--;
            }

            if (reachable > 0 && s.charAt(i) == '0') {
                memo[i] = true;
            }
        }

        return memo[s.length() - 1];
    }
}